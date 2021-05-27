#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
    File name: __init__.py
    Author: guyleaf
    Contact: ychhua1@gmail.com
    Time: 2021/5/27 3:58 PM
"""
import logging
import os

from flask import Flask
from flask_apscheduler import APScheduler

from .routes import blueprint as api

scheduler = APScheduler()


def create_app():
    instance = Flask(__name__)
    instance.config.from_object("config")
    scheduler.init_app(instance)
    logging.getLogger("apscheduler").setLevel(logging.INFO)

    if not instance.debug and os.environ.get("WERKZEUG_RUN_MAIN") == "true":
        from youtube import tasks, events
        scheduler.start()

    instance.register_blueprint(api, url_prefix="/api/v1")

    return instance


app = create_app()
