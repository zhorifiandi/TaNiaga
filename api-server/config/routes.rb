Rails.application.routes.draw do
  resources :transactions
  resources :items

  resources :users

  post '/sms/send', :to => "sms#send"
  # post '/sms/receive', :to => "sms#receive"

  # resources :sms do
  #   collection do
  #     post 'send', :to => "sms#send"
  #     post 'receive', :to => "sms#receive"
  #   end
  # end

  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  post 'authenticate', to: 'authentication#authenticate'

end
