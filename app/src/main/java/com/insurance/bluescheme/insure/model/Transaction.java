package com.insurance.bluescheme.insure.model;//
//	Transaction.java
//
//	Create by Newton@bscheme on 24/8/2016
//	Copyright © 2016. All rights reserved.
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;


public class Transaction implements Parcelable{

	private String amount;
	private String createdAt;
	private String description;
	private int id;
	private String itemId;
	private String messageId;
	private String transactionId;
	private String transactionType;
	private String updatedAt;
//	private Transaction transaction;

	public Transaction(){

	}
	protected Transaction(Parcel in) {
		amount = in.readString();
		createdAt = in.readString();
		description = in.readString();
		id = in.readInt();
		itemId = in.readString();
		messageId = in.readString();
		transactionId = in.readString();
		transactionType = in.readString();
		updatedAt = in.readString();
//		transaction = in.readParcelable(Transaction.class.getClassLoader());
	}

	public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
		@Override
		public Transaction createFromParcel(Parcel in) {
			return new Transaction(in);
		}

		@Override
		public Transaction[] newArray(int size) {
			return new Transaction[size];
		}
	};

	public void setAmount(String amount){
		this.amount = amount;
	}
	public String getAmount(){
		return this.amount;
	}
	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}
	public String getCreatedAt(){
		return this.createdAt;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return this.description;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setItemId(String itemId){
		this.itemId = itemId;
	}
	public String getItemId(){
		return this.itemId;
	}
	public void setMessageId(String messageId){
		this.messageId = messageId;
	}
	public String getMessageId(){
		return this.messageId;
	}
	public void setTransactionId(String transactionId){
		this.transactionId = transactionId;
	}
	public String getTransactionId(){
		return this.transactionId;
	}
	public void setTransactionType(String transactionType){
		this.transactionType = transactionType;
	}
	public String getTransactionType(){
		return this.transactionType;
	}
	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}
	public String getUpdatedAt(){
		return this.updatedAt;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public Transaction(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		amount = jsonObject.optString("amount");
		createdAt = jsonObject.optString("created_at");
		description = jsonObject.optString("description");
		id = jsonObject.optInt("id");
		itemId = jsonObject.optString("item_id");
		messageId = jsonObject.optString("message_id");
		transactionId = jsonObject.optString("transaction_id");
		transactionType = jsonObject.optString("transaction_type");
		updatedAt = jsonObject.optString("updated_at");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("amount", amount);
			jsonObject.put("created_at", createdAt);
			jsonObject.put("description", description);
			jsonObject.put("id", id);
			jsonObject.put("item_id", itemId);
			jsonObject.put("message_id", messageId);
			jsonObject.put("transaction_id", transactionId);
			jsonObject.put("transaction_type", transactionType);
			jsonObject.put("updated_at", updatedAt);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(amount);
		dest.writeString(createdAt);
		dest.writeString(description);
		dest.writeInt(id);
		dest.writeString(itemId);
		dest.writeString(messageId);
		dest.writeString(transactionId);
		dest.writeString(transactionType);
		dest.writeString(updatedAt);
	}
}