class SmsController < ApplicationController
  def send
    if request.post?
      render :text => 'post'
    else
      render :text => 'get'
    end
  end
end
