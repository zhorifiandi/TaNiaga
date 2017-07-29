require('telerivet')
require('rubygems')
require('nokogiri')

PROJECT_ID = 'PJa56814b121e855a8'
API_KEY = 'Q5FX2IsfDCGAFn4SJCDps0sdSe8ORXqr'
RECEIVED_URL = 'https://telerivet.com/p/a56814b1/messages?mode=m&f[dir]=1'

class SmsController < ApplicationController

  def index
    render :text => 'Index page of SMS Controller'
  end

  def show
    render :text => 'Index page of SMS Controller'
  end

  def receive_message
    if request.post?
      # page = Nokogiri::HTML(open(RECEIVED_URL))
      #
      # render plain: page.class
      render :text => 'mantap'
    end
  end

  def send_message
    if request.post?
      phone_number = params['phone_number']
      content_message = params['content_message']

      tr = Telerivet::API.new(API_KEY)
      project = tr.init_project_by_id(PROJECT_ID)

      Send a SMS message
      project.send_message({
          to_number: phone_number,
          content: content_message
      })

      ret_text = '{successful: "true", phone_number: ' + '"' + phone_number + '", ' + "content_message: " + '"' + content_message + '"}'

      # render plain: dummy
      render json: ret_text
    end
  end

end
