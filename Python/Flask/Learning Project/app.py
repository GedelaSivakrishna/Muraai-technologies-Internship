from flask import Flask
# from controller import controller

app = Flask(__name__)

products = [
    {
        "id": 1,
        "name": "Laptop"
    },
    {
        "id": 2,
        "name": "Bag"
    },
    {
        "id": 3,
        "name": "Book"
    },
    {
        "id": 4,
        "name":"Mobile"
    }
]

@app.route("/")
def hello_world():
    return "<p>Hello, World!</p>"

# Get Request
@app.route("/products")
def getProducts():
    return products

if __name__ == "__main__":
    app.run(debug=True)



