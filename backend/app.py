from flask import Flask
import os
app = Flask(__name__)


@app.route('/')
def home_page():
    return 'Hello, World!'

@app.route('/new')
def new():
    return 'new thing'

@app.route('/feed/user')
def feed_user():
    return 'feed user'

@app.route('/voteHot/id')
def vote_hot():
    return 'vote 1'

@app.route('/voteNot/id')
def vote_hot():
    return 'vote -1'

@app.route('/results/user')
def results_user():
    return 'user results page #govols'



if __name__ == '__main__':
    port = int(os.environ.get('PORT', 5000))
    app.run(debug=True,host='0.0.0.0', port=port)
