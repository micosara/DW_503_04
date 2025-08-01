package com.application.task;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.dao.RemoveFileSchedulerDAO;

public class RemoveSummernoteImagesScheduler {

	private RemoveFileSchedulerDAO removeFileSchedulerDAO;
	private String summernotePath;

	public RemoveSummernoteImagesScheduler(RemoveFileSchedulerDAO removeFileSchedulerDAO, String summernotePath) {
		this.removeFileSchedulerDAO = removeFileSchedulerDAO;
		this.summernotePath = summernotePath;
	}

	private static final Logger logger = LoggerFactory.getLogger(RemoveSummernoteImagesScheduler.class);

	public void fileRemove() throws Exception {
		File dir = new File(summernotePath);
		File[] files = dir.listFiles();

		if (files == null)
			return;

		for (File file : files) {
			boolean existFile = false;
			existFile = removeFileSchedulerDAO.selectCountUsedByImageFromBoard(file.getName()) > 0
					|| removeFileSchedulerDAO.selectCountUsedByImageFromNotice(file.getName()) > 0
					|| removeFileSchedulerDAO.selectCountUsedByImageFromPDS(file.getName()) > 0;
			if (existFile) {
				logger.info("[scheduler:유지] " + file.getName());
				continue;
			}
			logger.info("[scheduler:삭제] " + file.getName());
			if (file.exists())
				file.delete();

		}

	}
}
