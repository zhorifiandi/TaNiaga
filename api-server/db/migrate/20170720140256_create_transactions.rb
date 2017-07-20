class CreateTransactions < ActiveRecord::Migration[5.0]
  def change
    create_table :transactions do |t|
      t.datetime :date
      t.integer :item_id
      t.integer :seller_id
      t.integer :buyer_id
      t.string :item_name
      t.string :seller_name
      t.string :buyer_name
      t.integer :amount_price
      t.text :description

      t.timestamps
    end
  end
end
