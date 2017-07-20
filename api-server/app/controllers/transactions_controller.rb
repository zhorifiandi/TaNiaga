class TransactionsController < ApplicationController
  before_action :set_transaction, only: [:show, :update, :destroy]

  # GET /transactions
  def index
    @transactions = Transaction.all

    render json: @transactions
  end

  # GET /transactions/1
  def show
    render json: @transaction
  end

  # POST /transactions
  def create
    # Create random string for transactions code
    o = [('a'..'z'), ('A'..'Z')].map(&:to_a).flatten
    random_string = (0...5).map { o[rand(o.length)] }.join.upcase
    @transaction = Transaction.new(date: DateTime.now.to_date,
                                    item_id: params[:item_id],
                                    seller_id: params[:seller_id],
                                    buyer_id: params[:buyer_id],
                                    item_name: params[:item_name],
                                    seller_name: params[:seller_name],
                                    buyer_name: params[:buyer_name],
                                    amount_price: params[:amount_price],
                                    description: params[:description],
                                    transaction_code: random_string,
                                    ispaid: false,
                                    issent: false,
                                    isreceived: false,
                                    date_expired: 10.days.from_now )

    if @transaction.save
      render json: @transaction, status: :created, location: @transaction
    else
      render json: @transaction.errors, status: :unprocessable_entity
    end
  end

  # PATCH/PUT /transactions/1
  def update
    if @transaction.update(date: DateTime.now.to_date,
                                    item_id: params[:item_id],
                                    seller_id: params[:seller_id],
                                    buyer_id: params[:buyer_id],
                                    item_name: params[:item_name],
                                    seller_name: params[:seller_name],
                                    buyer_name: params[:buyer_name],
                                    amount_price: params[:amount_price],
                                    description: params[:description],
                                    transaction_code: random_string,
                                    ispaid: params[:ispaid],
                                    issent: params[:issent],
                                    isreceived: params[:isreceived],
                                    date_expired: params[:date_expired] )
      render json: @transaction
    else
      render json: @transaction.errors, status: :unprocessable_entity
    end
  end

  # DELETE /transactions/1
  def destroy
    @transaction.destroy
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_transaction
      @transaction = Transaction.find(params[:id])
    end

    # Only allow a trusted parameter "white list" through.
    def transaction_params
      params.fetch(:transaction, {})
    end
end
