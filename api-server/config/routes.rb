Rails.application.routes.draw do
  resources :transactions
  resources :items

  resources :users
  resources :sms do
    collection do
      post 'send'
    end
  end
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  post 'authenticate', to: 'authentication#authenticate'

end
