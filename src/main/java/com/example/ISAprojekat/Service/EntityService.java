package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.FastReservation;
import com.example.ISAprojekat.Model.RentingEntity;
import com.example.ISAprojekat.Model.UnavailablePeriod;

import java.util.Date;
import java.util.List;

public interface EntityService {
    public RentingEntity getEntityById(Integer id);
    List<? extends RentingEntity> GetAllEntities(int state);
    public RentingEntity findLockedById(Integer id);
    //private boolean isEntityBooked(Integer id);
    public FastReservation checkIfAlreadyReserved(FastReservation reservation);
    //private boolean checkOverlappingDates(FastReservation reservation, Date endDate);
    //private boolean checkFishingInstructorPeriods(FastReservation reservation,Date endDate);
    public RentingEntity fetchWithUnavailablePeriods(Integer id);
    public RentingEntity fetchWithSales (Integer id);
    public boolean checkIfSubscribed(String email,Integer entityId);
    public List<? extends RentingEntity> getEntitiesOnSale(int state);
    public List<? extends RentingEntity> getAvailableEntities(UnavailablePeriod unavailablePeriod, int state);
    //private boolean instructorAvailable(RentingEntity e, UnavailablePeriod unavailablePeriod);
}
