from flask import Flask
import os
import json
app = Flask(__name__)


@app.route('/')
def home_page():
    return 'homepage'

@app.route('/new')
def new():
    return json.dumps({'status': 'ok'})

@app.route('/feed/')
def feed_user():
    feed = [
            {
                'user': 'William Lifferth',
                'postID': 100001,
                'shirtURL': '/image/100001/shirt',
                'pants': {
                    '/image/100001/pants/0': 4,
                    '/image/100001/pants/1': 2,
                    '/image/100001/pants/2': 1,
                    '/image/100001/pants/4': 0,
                    }
            },
            {
                'user': 'Kelsey Veca',
                'postID': 100001,
                'shirtURL': '/image/100001/shirt',
                'pants': {
                    '/image/100002/pants/0': 2,
                    '/image/100002/pants/1': 1,
                    '/image/100002/pants/2': 4,
                    '/image/100002/pants/4': 1,
                    }
            },

    ]
    return json.dumps(feed)

@app.route('/voteHot/')
def vote_hot():
    return json.dumps({'status': 'ok'})

@app.route('/voteNot/')
def vote_not():
    return json.dumps({'status': 'ok'})

@app.route('/results/')
def results_user():
    feed = [
            {
                'user': 'William Lifferth',
                'postID': 100001,
                'shirtURL': '/image/100001/shirt',
                'pants': {
                    '/image/100001/pants/0': 4,
                    '/image/100001/pants/1': 2,
                    '/image/100001/pants/2': 1,
                    '/image/100001/pants/4': 0,
                    }
            },
            {
                'user': 'Kelsey Veca',
                'postID': 100001,
                'shirtURL': '/image/100001/shirt',
                'pants': {
                    '/image/100002/pants/0': 2,
                    '/image/100002/pants/1': 1,
                    '/image/100002/pants/2': 4,
                    '/image/100002/pants/4': 1,
                    }
            },

    ]
    return json.dumps(feed)


if __name__ == '__main__':
    port = int(os.environ.get('PORT', 5000))
    app.run(debug=True,host='0.0.0.0', port=port)
