#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
    File name: __init__.py
    Author: guyleaf
    Contact: ychhua1@gmail.com
    Time: 2021/5/27 6:01 PM
"""
from flask import Blueprint
from flask_restx import Api

from .youtube import youtube
from .trend import trend

blueprint = Blueprint("api", __name__)
api = Api(blueprint, title="Youtube trend analysis")
api.add_namespace(youtube)
api.add_namespace(trend)
