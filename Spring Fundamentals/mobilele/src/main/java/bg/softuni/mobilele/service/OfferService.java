package bg.softuni.mobilele.service;

import bg.softuni.mobilele.view.OfferSummaryViewModel;

import java.util.List;

public interface OfferService {
    List<OfferSummaryViewModel> getAllOffers();
}
