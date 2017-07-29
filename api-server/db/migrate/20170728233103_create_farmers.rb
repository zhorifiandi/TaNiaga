class CreateFarmers < ActiveRecord::Migration[5.0]
  def change
    create_table :farmers do |t|
      t.string :name
      t.string :phone_number
      t.integer :seller_id
      t.string :array_item

      t.timestamps
    end
  end
end
