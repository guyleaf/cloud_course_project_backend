#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
    File name: config.py
    Author: guyleaf
    Contact: ychhua1@gmail.com
    Time: 2021/5/27 4:00 PM
"""
from os import environ
from dotenv import load_dotenv

load_dotenv()

API_KEY: str = environ.get("API_KEY")
FLASK_ENV: str = environ.get("FLASK_ENV")
FLASK_DEBUG: bool = environ.get("FLASK_DEBUG") == "True" or environ.get("FLASK_DEBUG") == "true"
