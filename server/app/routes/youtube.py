#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
    File name: youtube.py
    Author: guyleaf
    Contact: ychhua1@gmail.com
    Time: 2021/5/27 5:59 PM
"""
from flask_restx import Namespace, Resource

youtube = Namespace("youtube", description="crawler related operations")


@youtube.route("/")
class Index(Resource):
    def get(self):
        return "crawler"
