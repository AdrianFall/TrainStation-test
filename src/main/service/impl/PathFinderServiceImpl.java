package main.service.impl;

import main.dto.QuickestPathDTO;
import main.exception.PathFinderServiceException;
import main.model.TrainStation;
import main.service.PathFinderService;

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
