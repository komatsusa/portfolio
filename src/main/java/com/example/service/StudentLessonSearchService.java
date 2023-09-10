package com.example.service;

import java.time.LocalDate;
import java.util.List;

import com.example.dao.StudentLessonDao;

/**
 * 授業登録内容を取得するサービス。
 * @author sa.komatsu
 * @version 1.0
 */
public class StudentLessonSearchService {

	StudentLessonDao studentLessonDao = new StudentLessonDao();

	/**
	 * 登録授業を生徒IDを条件に、日付順で取得。
	 * @param　studentId
	 * @return lesson名List
	 */
	public List<String> searchLessonsByStudentId(Integer studentId) {
		List<String> lessons = studentLessonDao.selectByStudentId(studentId);
		return lessons;
	}

	/**
	 * 登録授業を生徒IDと期間を条件に、日付順で取得。
	 * @param　studentId
	 * @param　startDate
	 * @param　endDate
	 * @return lesson名List
	 */
	public List<String> searchLessonsByStudentIdAndDates(Integer studentId, LocalDate startDate, LocalDate endDate) {
		List<String> lessons = studentLessonDao.selectByStudentIdAndDates(studentId, startDate, endDate);
		return lessons;
	}

	
}
