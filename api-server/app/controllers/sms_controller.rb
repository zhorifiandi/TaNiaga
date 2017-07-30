# require('nokogiri')
require('telerivet')
require('rubygems')
require('open-uri')
require('json')

KURAWAL = '{'
PROJECT_ID = 'PJa56814b121e855a8'
API_KEY = 'Q5FX2IsfDCGAFn4SJCDps0sdSe8ORXqr'
MESSAGE_LIMIT = 100
RECEIVED_URL = 'https://telerivet.com/p/a56814b1/messages?mode=m&f[dir]=1'

# GET /v1 HTTP/1.1
# Authorization: Basic base64_encode(YOUR_API_KEY:)
# ...

class SmsController < ApplicationController

  def index
    render :text => 'Index page of SMS Controller'
  end

  def show
    render :text => 'Index page of SMS Controller'
  end

  def find_char (message, char)
    return message.index(char)
  end

  def query_phone(phone_number)

    tr = Telerivet::API.new(API_KEY)
    project = tr.init_project_by_id(PROJECT_ID)

    cursor = project.query_phones({
      'phone_number' => phone_number
    });

    cursor.limit(1).each { |phone|
      # Convert Telerivet::Phone to string
      phone_str = phone.to_s
      # Dump all the characters before '{'
      kurawal_index = find_char(phone_str, KURAWAL)
      phone_str = phone_str[kurawal_index..-1]
      # Parse string to JSON object
      phone_obj = JSON.parse(phone_str)

      phone_id = phone_obj['id']
      puts('ANJRIT')
      puts(phone_id)

      # Return phone id
      return phone_id
    }
  end

  def save_incoming_message
    if request.post?
      # Current user/agent
      agent_phone_number = params['agent_phone_number']
      puts('BANGSAT')
      puts(agent_phone_number)

      # Initiate Telerivet::API
      tr = Telerivet::API.new(API_KEY)
      project = tr.init_project_by_id(PROJECT_ID)

      # Hash to save all messages
      all_message_hash = Hash.new

      # Retrieve all messages
      cursor = project.query_messages({
          'direction' => "incoming",
          'message_type' => "sms",
          # Dummy phone number, harus diganti sama current user
          'phone_id' => query_phone(agent_phone_number)
      })

      # Iterate over messages
      cursor.limit(MESSAGE_LIMIT).each { |message|
          # Convert Telerivet::Message to string
          message_str = message.to_s
          # Dump all the characters before '{'
          kurawal_index = find_char(message_str, KURAWAL)
          message_str = message_str[kurawal_index..-1]
          # Parse string to JSON object
          message_obj = JSON.parse(message_str)

          puts(message_obj)

          # Get sender and content
          sender = message_obj['from_number']
          content = message_obj['content']

          if (!all_message_hash.key?(sender))
            all_message_hash[sender] = Array.new
          end

          all_message_hash[sender].push(content)
      }

      # Delete all messages
      IncomingMessage.destroy_all(:agent_phone_number => agent_phone_number)

      # Insert all scrapped messages to db
      all_message_hash.each do |key, array|
        new_message_obj = IncomingMessage.new(:agent_phone_number => agent_phone_number.to_s, :from_number => key.to_s, :list_of_contents => array)
        new_message_obj.save!
      end

      render json: all_message_hash
    end
  end

  def save_outcoming_message
    if request.post?
      # Current user/agent
      agent_phone_number = params['agent_phone_number']
      puts('BANGSAT')
      puts(agent_phone_number)

      # Initiate Telerivet::API
      tr = Telerivet::API.new(API_KEY)
      project = tr.init_project_by_id(PROJECT_ID)

      # Hash to save all messages
      all_message_hash = Hash.new

      # Retrieve all messages
      cursor = project.query_messages({
          'direction' => "outgoing",
          'message_type' => "sms",
          # Dummy phone number, harus diganti sama current user
          'phone_id' => query_phone(agent_phone_number)
      })

      # Iterate over messages
      cursor.limit(MESSAGE_LIMIT).each { |message|
          # Convert Telerivet::Message to string
          message_str = message.to_s
          # Dump all the characters before '{'
          kurawal_index = find_char(message_str, KURAWAL)
          message_str = message_str[kurawal_index..-1]
          # Parse string to JSON object
          message_obj = JSON.parse(message_str)

          puts(message_obj)

          # Get sender and content
          sender = message_obj['to_number']
          content = message_obj['content']

          if (!all_message_hash.key?(sender))
            all_message_hash[sender] = Array.new
          end

          all_message_hash[sender].push(content)
      }

      # Delete all messages
      OutcomingMessage.destroy_all(:agent_phone_number => agent_phone_number)

      # Insert all scrapped messages to db
      all_message_hash.each do |key, array|
        new_message_obj = OutcomingMessage.new(:agent_phone_number => agent_phone_number.to_s, :to_number => key.to_s, :list_of_contents => array)
        new_message_obj.save!
      end

      render json: all_message_hash
    end
  end

  # Ini ngasitau yg ngirim siapa gimana?
  def send_message
    if request.post?
      phone_number = params['phone_number'].to_str
      content_message = params['content_message'].to_str

      tr = Telerivet::API.new(API_KEY)
      project = tr.init_project_by_id(PROJECT_ID)

      # Send a SMS message
      project.send_message({
          to_number: phone_number,
          content: content_message
      })

      ret_hash = {"successful" => 'true', 'phone_number' => phone_number, 'content_message' => content_message}

      render json: ret_hash
    end
  end

end
