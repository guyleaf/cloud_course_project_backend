from flask import Flask
from dotenv import dotenv_values
from apscheduler.schedulers.background import BackgroundScheduler
from apscheduler.triggers.cron import CronTrigger

config = dotenv_values(".env")
app = Flask(__name__)

@app.route('/status', methods=['GET'])
def status():
    return 'hello world!'

if __name__ == '__main__':
    app.run(debug=config["ENVIRONMENT"] == "development")