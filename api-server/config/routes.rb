Rails.application.routes.draw do
  resources :transactions
  resources :items

  resources :users do
    collection do
      post 'show_by_email'
    end
  end

  # post '/sms/send_message', :to => "sms#send_message"
  # post '/sms/savereceive_message', :to => "sms#receive_message"

  resources :sms do
    collection do
      post 'send_message'
      post 'save_incoming_message'
      post 'save_outcoming_message'
    end
  end

  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  post 'authenticate', to: 'authentication#authenticate'

end
