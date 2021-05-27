#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
    File name: trend.py
    Author: guyleaf
    Contact: ychhua1@gmail.com
    Time: 2021/5/27 5:59 PM
"""
from flask_restx import Namespace, Resource

trend = Namespace("trend", description="trend analysis related operations")


@trend.route("/")
class Index(Resource):
    def get(self):
        return "trend"
