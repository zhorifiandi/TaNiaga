class User < ApplicationRecord
  validates :name, :email, :address, :presence => true
  has_secure_password
end
