package com.example.service;

import java.util.List;

import com.example.dao.StudentClassDao;
import com.example.dao.StudentLessonDao;
import com.example.entity.StudentLesson;

/**
 * 授業登録サービス。
 * @author sa.komatsu
 * @version 1.0
 */
public class LessonRegistService {

	StudentLessonDao studentLessonDao = new StudentLessonDao();
	StudentClassDao studentClassDao = new StudentClassDao();

	/**
	 * 生徒に授業を登録する。
	 * 同じ授業が登録済みの場合は、登録しない。
	 * @param　studentId
	 * @param　lessonId
	 */
	public void registerLesson(Integer studentId, Integer lessonId) {
		StudentLesson studentLesson = new StudentLesson(studentId, lessonId);
		studentLessonDao.insert(studentLesson);
	}
	
	/**
	 * 対象クラスに所属している生徒全員に授業を登録する。
	 * 同じ授業が登録済みの場合は、登録しない。
	 * @param　classId
	 * @param　lessonId
	 */
	public void registerLessonByClassId(Integer classId, Integer lessonId) {
		List<Integer> studentIds = studentClassDao.selectByClassId(classId);
		for (Integer studentId : studentIds) {
			this.registerLesson(studentId, lessonId);
		}
	}
	
}
