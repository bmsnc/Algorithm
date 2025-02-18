
with temp as (
    select (100 - replace(discount_rate, '%', '')) / 100 rate,
        case
            when (duration_type = '90일 이상') then 90
            when (duration_type = '30일 이상') then 30
            when (duration_type = '7일 이상') then 7
            else 0
        end as duration
        from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where car_type = '트럭'
)

select rental.history_id,
       case
           when (datediff(rental.end_date, rental.start_date) + 1 >= 90)
               then round(car.daily_fee * (select rate
                                           from temp
                                           where duration = 90) * (datediff(rental.end_date, rental.start_date) + 1), 0)
           when (datediff(rental.end_date, rental.start_date) + 1 >= 30)
               then round(car.daily_fee * (select rate
                                           from temp
                                           where duration = 30) * (datediff(rental.end_date, rental.start_date) + 1), 0)
           when (datediff(rental.end_date, rental.start_date) + 1 >= 7)
               then round(car.daily_fee * (select rate
                                           from temp
                                           where duration = 7) * (datediff(rental.end_date, rental.start_date) + 1), 0)
           else car.daily_fee * (datediff(rental.end_date, rental.start_date) + 1)
           end fee
from CAR_RENTAL_COMPANY_CAR car
         join CAR_RENTAL_COMPANY_RENTAL_HISTORY rental
              on car.car_id = rental.car_id and car.car_type = '트럭'
order by fee desc, history_id desc

-- SELECT H.HISTORY_ID,
--        ROUND(C.DAILY_FEE * (DATEDIFF(H.END_DATE, H.START_DATE) + 1) * (1 - IFNULL(D.DISCOUNT_RATE, 0) / 100), 0) AS FEE
-- FROM CAR_RENTAL_COMPANY_CAR C
--          JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H
--               ON C.CAR_ID = H.CAR_ID
--          LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN D
--                    ON C.CAR_TYPE = D.CAR_TYPE
--                        AND D.DURATION_TYPE =
--                            CASE
--                                WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 90 THEN '90일 이상'
--                                WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '30일 이상'
--                                WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 7 THEN '7일 이상'
--                                END
-- WHERE C.CAR_TYPE = '트럭'
-- ORDER BY FEE DESC, H.HISTORY_ID DESC;