
from flask import Flask, jsonify

app = Flask(__name__)

# The route() function of the Flask class is a decorator, which tells the application which URL should call the associated function.
@app.route('/api/hello', methods=['GET'])
def hello():
    return jsonify(message='Hello, World!')

if __name__ == '__main__':
    # the run() method of Flask class runs the application on the local development server.
    app.run(debug=True)
