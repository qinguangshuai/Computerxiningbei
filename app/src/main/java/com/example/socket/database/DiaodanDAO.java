package com.example.socket.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @date 2021/9/24 15:00
 */
@Dao
public interface DiaodanDAO {
    @Query("SELECT * FROM diaodan")
    List<DiaoDan> getAll();

    @Query("SELECT * FROM diaodan WHERE reportid = :reportId LIMIT 1")
    DiaoDan findByID(int reportId);

    @Query("SELECT * FROM diaodan WHERE currentTime = :current_time LIMIT 1")
    DiaoDan findByDate(String current_time);

    @Query("select * from diaodan order by curTime desc")
    List<DiaoDan> findByTime();

    @Query("select count(1) from diaodan WHERE danhao = :danhao")
    int findBydanhao(String danhao);

    @Query("update diaodan set str = :str,currentTime = :current_time,curTime = :curTime where gjhId = :gjhId")
    void updateChongStr04(String str, String current_time, String curTime, String gjhId);

    @Query("update diaodan set str = :str,currentTime = :current_time,curTime = :cur_time,gou_number = :gou_number  where danhao = :danhao")
    void updateChongStr03(String str, String current_time, String cur_time, String gou_number, String danhao);

    @Query("select count(1) from diaodan WHERE gjhId = :gjhId")
    int findByGjhId(String gjhId);

    @Query("select * from diaodan WHERE gjhId = :gjhId")
    List<DiaoDan> findByGjId(String gjhId);

    @Query("select * from diaodan where danhao = :danhao")
    List<DiaoDan> findBy(String danhao);

    @Insert
    void insertAll(DiaoDan... diaodan);

    @Insert
    long insert(DiaoDan diaodan);

    @Delete
    void delete(DiaoDan diaodan);

    @Update
    public void updateDiaodan(DiaoDan... diaodan);

    @Query("DELETE FROM diaodan")
    void deleteAll();

    @Query("delete from diaodan where str = :str")
    void deleteStr(String str);

    @Query("update diaodan set state = :state where str = :str")
    void updateStr(String state, String str);

    @Query("update diaodan set state = :state")
    void updateState(String state);

    @Query("select * from diaodan where state = :state")
    List<DiaoDan> getStudentById(String state);

    @Query("update diaodan set gou_number = :gou_number where currentTime = :current_time")
    void updateGouNumber(String gou_number, String current_time);

    @Query("update diaodan set curTime = :cur_time where str = :str")
    void updateTime(String cur_time, String str);

    @Query("update diaodan set curTime = :cur_time where currentTime = :currentTime")
    void updateCurTime(String cur_time, String currentTime);

    //删除七天以前的数据
}
