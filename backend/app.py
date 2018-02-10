from flask import Flask
app = Flask(__name__)


@app.route('/')
def hello_world():
    return 'Hello, World!'


@app.route('/new_message')
def new_message():
    return 'YOLO!'

if __name__ == '__main__':
    app.run(debug=True,host='0.0.0.0')
