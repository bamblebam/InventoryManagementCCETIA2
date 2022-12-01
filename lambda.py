import os

from pymongo import MongoClient
from dotenv import load_dotenv

def get_db():
    connectionUrl=os.getenv("MONGODB_URI")
    client = MongoClient(connectionUrl,3000)
    # dbName=os.getenv("MONGODB_DB")
    dbName="myFirstDatabase"
    db = client[dbName]
    return db

def get_collection(db,collectionName):
    collection = db[collectionName]
    return collection

def get_all_documents(collection):
    documents = collection.find()
    return documents


if __name__ == '__main__':
    db = get_db()
    print(db)
    # inventory = get_collection(db,"inventory")
    # inventoryItem=get_collection(db,"inventoryItem")
    # documents = get_all_documents(inventory)
    collection=db['inventoryItem']
    print('collection',collection)
    documents=collection.find()
    print('documents',documents)
    for document in documents:
        print(document)