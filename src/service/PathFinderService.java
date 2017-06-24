package service;

import dto.QuickestPathDTO;
import exception.PathFinderServiceException;
import model.TrainStation;

/**
 * Created by Adrian on 24/06/2017.
 */
public interface PathFinderService {

    QuickestPathDTO getQuickestPath(TrainStation origin, TrainStation target) throws PathFinderServiceException;

}
