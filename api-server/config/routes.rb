Rails.application.routes.draw do
  resources :transactions
  resources :items

  resources :users

  post '/sms/send_message', :to => "sms#send_message"
  post '/sms/receive_message', :to => "sms#receive_message"

  # resources :sms do
  #   collection do
  #     post 'send', :to => "sms#send"
  #     post 'receive', :to => "sms#receive"
  #   end
  # end

  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  post 'authenticate', to: 'authentication#authenticate'

end
