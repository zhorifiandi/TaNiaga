class Transaction < ApplicationRecord
  validates :item_id, :seller_id, :buyer_id, :amount_price, :presence => true
end
