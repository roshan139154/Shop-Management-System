const User = require('../models/user');
var bcrypt = require('bcrypt-nodejs');
const _ = require('lodash');
const { v4 } = require('uuid');
const jwt = require('jsonwebtoken');
const { formatResponse } = require('../server/middleware/responseMiddleware');

let register = async () => {
    return new Promise(async (resolve, reject) => {
        try {
        } catch (error) {
        }
    })
}

module.exports = {
    register
}