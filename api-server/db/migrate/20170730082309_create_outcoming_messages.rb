class CreateOutcomingMessages < ActiveRecord::Migration[5.0]
  def change
    create_table :outcoming_messages do |t|
      t.string :agent_phone_number
      t.string :to_number
      t.string :list_of_contents

      t.timestamps
    end
  end
end
