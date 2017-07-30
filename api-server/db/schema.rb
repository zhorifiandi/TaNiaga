# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20170730082309) do

  create_table "farmers", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=latin1" do |t|
    t.string   "name"
    t.string   "phone_number"
    t.integer  "seller_id"
    t.string   "array_item"
    t.datetime "created_at",   null: false
    t.datetime "updated_at",   null: false
  end

  create_table "incoming_messages", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=latin1" do |t|
    t.string   "from_number"
    t.string   "list_of_contents"
    t.datetime "created_at",       null: false
    t.datetime "updated_at",       null: false
  end

  create_table "items", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=latin1" do |t|
    t.string   "name"
    t.text     "description",  limit: 65535
    t.string   "category"
    t.integer  "price"
    t.string   "variety"
    t.string   "dimension"
    t.string   "seller_email"
    t.datetime "created_at",                 null: false
    t.datetime "updated_at",                 null: false
  end

  create_table "outcoming_messages", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=latin1" do |t|
    t.string   "to_number"
    t.string   "list_of_contents"
    t.datetime "created_at",       null: false
    t.datetime "updated_at",       null: false
  end

  create_table "sellers", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=latin1" do |t|
    t.string   "name"
    t.string   "email"
    t.string   "address"
    t.string   "phone_number"
    t.integer  "user_id"
    t.string   "array_farmer"
    t.string   "array_item"
    t.datetime "created_at",   null: false
    t.datetime "updated_at",   null: false
  end

  create_table "sms", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=latin1" do |t|
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "transactions", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=latin1" do |t|
    t.datetime "date"
    t.integer  "item_id"
    t.integer  "seller_id"
    t.integer  "buyer_id"
    t.string   "item_name"
    t.string   "seller_name"
    t.string   "buyer_name"
    t.integer  "amount_price"
    t.text     "description",      limit: 65535
    t.string   "transaction_code"
    t.boolean  "ispaid"
    t.boolean  "issent"
    t.boolean  "isreceived"
    t.datetime "date_expired"
    t.datetime "created_at",                     null: false
    t.datetime "updated_at",                     null: false
  end

  create_table "users", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=latin1" do |t|
    t.string   "name"
    t.string   "email"
    t.string   "password_digest"
    t.string   "address"
    t.string   "phone_number"
    t.datetime "created_at",      null: false
    t.datetime "updated_at",      null: false
  end

end
