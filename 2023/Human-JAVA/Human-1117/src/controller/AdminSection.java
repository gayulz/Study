package controller;

import dao.FindDao;
import dao.SaveDao;
import dto.WordDTO;
import resource.Driver;

public class AdminSection {

    private static Driver driver = Driver.getInstance();

    public AdminSection() {}

    protected static void saveTransfer(WordDTO nowDto) {
        if (driver != null) SaveDao.getInstance().daoTransper(nowDto);
    }

    protected static WordDTO findTransfer(WordDTO nowDto) {
        FindDao findDao = FindDao.getInstance();
        WordDTO tmpDto = null;
        if (driver != null) {
            tmpDto = findDao.daoTransper(nowDto);
        }
        return tmpDto;
    }
}
