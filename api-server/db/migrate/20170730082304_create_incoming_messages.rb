class CreateIncomingMessages < ActiveRecord::Migration[5.0]
  def change
    create_table :incoming_messages do |t|
      t.string :agent_phone_number
      t.string :from_number
      t.string :list_of_contents

      t.timestamps
    end
  end
end
