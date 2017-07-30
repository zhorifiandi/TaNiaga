class CreateItems < ActiveRecord::Migration[5.0]
  def change
    create_table :items do |t|
      t.string :name
      t.text :description
      t.string :category
      t.integer :price
      t.string :variety
      t.string :dimension
      t.string :seller_email
      t.string :seller_name
      t.integer :seller_id

      t.timestamps
    end
  end
end
