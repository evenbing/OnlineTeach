package com.teachMng.onlineTeach.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.ICompletionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.service.ICompletionExerciseService;

@Component("completionExerciseService")
public class CompletionExerciseServiceImpl implements ICompletionExerciseService {
	private ICompletionExerciseDAO completionExerciseDao;
	public ICompletionExerciseDAO getCompletionExerciseDao() {
		return completionExerciseDao;
	}
	@Resource(name="completionExerciseDao")
	public void setCompletionExerciseDao(
			ICompletionExerciseDAO completionExerciseDao) {
		this.completionExerciseDao = completionExerciseDao;
	}

	@Override
	@Transactional
	public List<CompletionExercise> allExercise() {
		// TODO Auto-generated method stub
		return completionExerciseDao.allExercise();
	}

	@Override
	@Transactional
	public CompletionExercise findById(int id) {
		// TODO Auto-generated method stub
		return completionExerciseDao.findById(id);
	}

	@Override
	@Transactional
	public boolean insert(CompletionExercise ce) {
		// TODO Auto-generated method stub
		return completionExerciseDao.insert(ce);
	}
	@Transactional
	public String getCEString() {
		List<CompletionExercise> ceList = allExercise();
		String json = "";
		Iterator<CompletionExercise> ceIter = ceList.iterator();
		CompletionExercise _ce;
		String topic = "";
		while(ceIter.hasNext()) {
			_ce = ceIter.next();
			topic = _ce.getFullTopic();
			topic = topic.replaceAll("@space@", "_______");
			if(topic.length() > 31) {
				topic = topic.substring(0, 31);
				topic += "...";
			}
			json += "{id:\"" + _ce.getId() + "\",topic:\"" + topic + "\",type:\"completionExercise\"},";
		}
		return json;
	}
	@Override
	@Transactional
	public String quickLook(int id) {
		// TODO Auto-generated method stub
		CompletionExercise ce = findById(id);
		String json="{";
		json += "填空题：" + ce.getFullTopic().replaceAll("@space@", "_______") + "}";
		return json;
	}

}
