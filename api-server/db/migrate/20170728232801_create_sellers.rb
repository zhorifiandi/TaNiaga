class CreateSellers < ActiveRecord::Migration[5.0]
  def change
    create_table :sellers do |t|
      t.string :name
      t.string :email
      t.string :address
      t.string :phone_number
      t.integer :user_id
      t.string :array_farmer
      t.string :array_item
      t.timestamps
    end
  end
end
