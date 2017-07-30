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

  def save_incoming_message
    if request.post?
      # Initiate Telerivet::API
      tr = Telerivet::API.new(API_KEY)
      project = tr.init_project_by_id(PROJECT_ID)

      # Hash to save all messages
      all_message_hash = Hash.new

      # Retrieve all messages
      cursor = project.query_messages({
          'direction' => "incoming",
          'message_type' => "sms"
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

          # Get sender and content
          sender = message_obj['from_number']
          content = message_obj['content']

          if (!all_message_hash.key?(sender))
            all_message_hash[sender] = Array.new
          end

          all_message_hash[sender].push(content)
      }

      # Delete all messages
      IncomingMessage.delete_all

      # Insert all scrapped messages to db
      all_message_hash.each do |key, array|
        new_message_obj = IncomingMessage.new(:from_number => key, :list_of_contents => array)
        new_message_obj.save!
      end

      render json: all_message_hash
    end
  end

  def save_outcoming_message
    if request.post?
      # Initiate Telerivet::API
      tr = Telerivet::API.new(API_KEY)
      project = tr.init_project_by_id(PROJECT_ID)

      # Hash to save all messages
      all_message_hash = Hash.new

      # Retrieve all messages
      cursor = project.query_messages({
          'direction' => "outgoing",
          'message_type' => "sms"
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

          # Get sender and content
          sender = message_obj['to_number']
          content = message_obj['content']

          if (!all_message_hash.key?(sender))
            all_message_hash[sender] = Array.new
          end

          all_message_hash[sender].push(content)
      }

      # Delete all messages
      OutcomingMessage.delete_all

      # Insert all scrapped messages to db
      all_message_hash.each do |key, array|
        new_message_obj = OutcomingMessage.new(:to_number => key, :list_of_contents => array)
        new_message_obj.save!
      end

      render json: all_message_hash
    end
  end

  def send_message
    if request.post?
      phone_number = params['phone_number'].to_str
      content_message = params['content_message'].to_str

      # Uncomment this to send the real message
      # tr = Telerivet::API.new(API_KEY)
      # project = tr.init_project_by_id(PROJECT_ID)

      # Send a SMS message
      # project.send_message({
      #     to_number: phone_number,
      #     content: content_message
      # })

      ret_hash = {"successful" => 'true', 'phone_number' => phone_number, 'content_message' => content_message}

      render json: ret_hash
    end
  end

end
