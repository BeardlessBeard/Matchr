from flask import Flask, send_file
import os
import json
app = Flask(__name__)

dir_path = os.path.dirname(os.path.realpath(__file__))

feed =
[
    {
        'user': 'William Lifferth',
        'postID': 100001,
        'shirtURL': '/image/100001/shirt.jpg',
        'pants': {
            '/image/100001/pants/0.jpg': 4,
            '/image/100001/pants/1.jpg': 2,
            '/image/100001/pants/2.jpg': 1,
            }
        },
    {
        'user': 'Kelsey Veca',
        'postID': 100001,
        'shirtURL': '/image/100001/shirt.jpg',
        'pants': {
            '/image/100002/pants/0.jpg': 2,
            '/image/100002/pants/1.jpg': 1,
            '/image/100002/pants/2.jpg': 4,
            '/image/100002/pants/3.jpg': 1,
            }
        },

]

@app.route('/')
def home_page():
    return 'homepage'

@app.route('/new')
def new():
    return json.dumps({'status': 'ok'})

@app.route('/feed/')
def feed_user():
    return json.dumps(feed)

@app.route('/voteHot/')
def vote_hot():
    return json.dumps({'status': 'ok'})

@app.route('/voteNot/')
def vote_not():
    return json.dumps({'status': 'ok'})

@app.route('/results/')
def results_user():
    return json.dumps(feed)

@app.route('/image/<int:post_id>/pants/<filename>')
def image(post_id, filename):
    return send_file('{}/image/{}/pants/{}'.format(dir_path, post_id, filename))


if __name__ == '__main__':
    port = int(os.environ.get('PORT', 5000))
    app.run(debug=True,host='0.0.0.0', port=port)
