from fastapi import FastAPI, Depends
from pydantic import BaseModel
import os
from dotenv import load_dotenv
load_dotenv()
from database import Base, get_db, engine
from models import TodoModel
from sqlalchemy.orm import Session
from typing import List

app = FastAPI() # creates an instance of FastAPI
# app is the main component of the application. It helps in configuring the application

# Create tables that doesn't exist in db
Base.metadata.create_all(bind=engine)

todos = []

class Todo(BaseModel):
    description: str
    completed: bool = False

@app.get("/todos")
def getTodos(db: Session = Depends(get_db)):
    todos = db.query(TodoModel).all()
    return todos

@app.get("/todos/{todo_id}")
def getTodo(todo_id: int, db: Session = Depends(get_db)):
    todo = db.query(TodoModel).filter(TodoModel.id == todo_id)
    return todo.first()

@app.post("/todos")
def create_todo(todo: Todo, db: Session = Depends(get_db)):
    todo = TodoModel(description=todo.description, completed=todo.completed)
    db.add(todo)
    db.commit()
    db.refresh(todo)
    return todo


