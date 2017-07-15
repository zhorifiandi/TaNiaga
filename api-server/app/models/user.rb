class User < ApplicationRecord
  validates :name, :email, :password,:address, :presence => true
  has_secure_password
end
