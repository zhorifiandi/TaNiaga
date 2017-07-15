class Item < ApplicationRecord
  validates :name, :description, :price, :presence => true
end
