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

      t.timestamps
    end
  end
end
