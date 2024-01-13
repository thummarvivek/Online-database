package com.mymusic.testofkotlin.searchdemof

class Course{
    var courseName: String? = null
    var courseDescrip: String? = null

    constructor(courseName: String, courseDescrip: String) {
        this.courseName = courseName
        this.courseDescrip = courseDescrip
    }
}