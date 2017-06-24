package service.impl;

import dto.QuickestPathDTO;
import exception.PathFinderServiceException;
import model.TrainStation;
import service.PathFinderService;

/**
 * Created by Adrian on 24/06/2017.
 */
public class PathFinderServiceImpl implements PathFinderService {
    @Override
    public QuickestPathDTO getQuickestPath(TrainStation origin, TrainStation target) throws PathFinderServiceException {
        // TODO : some magic!
        return null;
    }
}
