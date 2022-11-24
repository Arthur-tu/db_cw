package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DBHandler extends Config {
    Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String patern = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(patern, dbUser, dbPass);
        return connection;
    }

    public void deletePatient(Patient patient) {
        String delete = "DELETE FROM " + Const.PATIENT_TABLE + " WHERE " + Const.PATIENT_WARD_ID + "=? AND " +
                Const.PATIENT_WORKERS_ID + "=? AND " + Const.PATIENT_NAME + "=? AND " + Const.PATIENT_SURNAME
                + "=? AND " + Const.PATIENT_PATRONYMIC + "=? AND " + Const.PATIENT_START_TIME + "=? AND " +
                Const.PATIENT_END_TIME + "=? AND " + Const.PATIENT_HEALTH_DESCRIPTION + "=? AND " +
                Const.PATIENT_TEMPRITURE + "=?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(delete);
            preparedStatement.setInt(1, patient.getIdWard());
            preparedStatement.setInt(2, patient.getIdWorker());
            preparedStatement.setString(3, patient.getName());
            preparedStatement.setString(4, patient.getSurname());
            preparedStatement.setString(5, patient.getPartonynic());
            preparedStatement.setDate(6, patient.getStart_time());
            preparedStatement.setDate(7, patient.getEnd_time());
            preparedStatement.setString(8, patient.getHealth());
            preparedStatement.setInt(9, patient.getTemperature());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void signUpPatient(Patient patient) {
        String insert = "INSERT INTO " + Const.PATIENT_TABLE + "(" + Const.PATIENT_WARD_ID + "," +
                Const.PATIENT_WORKERS_ID + "," + Const.PATIENT_NAME + "," + Const.PATIENT_SURNAME + "," +
                Const.PATIENT_PATRONYMIC + "," + Const.PATIENT_START_TIME + "," + Const.PATIENT_END_TIME + "," +
                Const.PATIENT_HEALTH_DESCRIPTION + "," + Const.PATIENT_TEMPRITURE + ")" +  "VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setInt(1, patient.getIdWard());
            preparedStatement.setInt(2, patient.getIdWorker());
            preparedStatement.setString(3, patient.getName());
            preparedStatement.setString(4, patient.getSurname());
            preparedStatement.setString(5, patient.getPartonynic());
            preparedStatement.setDate(6, patient.getStart_time());
            preparedStatement.setDate(7, patient.getEnd_time());
            preparedStatement.setString(8, patient.getHealth());
            preparedStatement.setInt(9, patient.getTemperature());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Patient> getListPatirnts() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.PATIENT_TABLE;
        ArrayList<Patient> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Patient p = new Patient();
                p.setIdWard(resultSet.getInt("ward_id"));
                p.setIdWorker(resultSet.getInt("workers_id"));
                p.setName(resultSet.getString("name"));
                p.setSurname(resultSet.getString("surname"));
                p.setPartonynic(resultSet.getString("patronymic"));
                p.setStart_time(resultSet.getDate("start_time"));
                p.setEnd_time(resultSet.getDate("end_time"));
                p.setHealth(resultSet.getString("health_description"));
                p.setTemperature(resultSet.getInt("tempriture"));
                arrayList.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public Set<String> getPatirntsSet() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.PATIENT_TABLE;
        Set<String> set = new HashSet<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                set.add(resultSet.getString("name") +
                        resultSet.getString("surname") +
                        resultSet.getString("patronymic"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    public void updatePatient(Patient patient) {
        String update = "UPDATE " + Const.PATIENT_TABLE + " SET " + Const.PATIENT_WARD_ID +"=? " + "," +
                Const.PATIENT_WORKERS_ID + "=? " + "," + Const.PATIENT_START_TIME + "=? " + "," +
                Const.PATIENT_END_TIME + "=? " + "," + Const.PATIENT_HEALTH_DESCRIPTION + "=? " + "," +
                Const.PATIENT_TEMPRITURE + "=? " + " WHERE " + Const.PATIENT_NAME + "=? AND " +
                Const.PATIENT_SURNAME + "=? AND " + Const.PATIENT_PATRONYMIC + "=?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(update);
            preparedStatement.setInt(1, patient.getIdWard());
            preparedStatement.setInt(2, patient.getIdWorker());
            preparedStatement.setDate(3, patient.getStart_time());
            preparedStatement.setDate(4, patient.getEnd_time());
            preparedStatement.setString(5, patient.getHealth());
            preparedStatement.setInt(6, patient.getTemperature());
            preparedStatement.setString(7, patient.getName());
            preparedStatement.setString(8, patient.getSurname());
            preparedStatement.setString(9, patient.getPartonynic());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Ward> getListWards() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + ConstWard.WARD_TABLE;
        ArrayList<Ward> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Ward w = new Ward();
                w.setDepartaments_id(resultSet.getInt("departaments_id"));
                w.setTitle(resultSet.getString("title"));
                arrayList.add(w);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void signUpWard(Ward w) {
        String insert = "INSERT INTO " + ConstWard.WARD_TABLE + "(" + ConstWard.WARD_DEPARTAMENTS_ID + "," +
                ConstWard.WARD_TITLE + ")" +  "VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setInt(1, w.getDepartaments_id());
            preparedStatement.setString(2, w.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public Set<String> getWardsSet() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + ConstWard.WARD_TABLE;
        Set<String> set = new HashSet<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                set.add(resultSet.getString("departaments_id") + resultSet.getString("title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    public void deleteWard(Ward ward) {
        String delete = "DELETE FROM " + ConstWard.WARD_TABLE + " WHERE " + ConstWard.WARD_DEPARTAMENTS_ID + "=? AND " +
                ConstWard.WARD_TITLE + "=?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(delete);
            preparedStatement.setInt(1, ward.getDepartaments_id());
            preparedStatement.setString(2, ward.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateWard(Ward w) {
        String update = "UPDATE " + ConstWard.WARD_TABLE + " SET " + ConstWard.WARD_DEPARTAMENTS_ID +"=? " + " WHERE " +
                ConstWard.WARD_TITLE + "=?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(update);
            preparedStatement.setInt(1, w.getDepartaments_id());
            preparedStatement.setString(2, w.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<MedicalInstitution> getListMeds() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + ConstMedicalInstitution.MedicalInstitution_TABLE;
        ArrayList<MedicalInstitution> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MedicalInstitution med = new MedicalInstitution();
                med.setTitle(resultSet.getString("title"));
                med.setPurpose(resultSet.getString("purpose"));
                med.setType(resultSet.getString("type"));
                med.setContact_data(resultSet.getString("contact_data"));
                arrayList.add(med);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void deleteMed(MedicalInstitution medicalInstitution) {
        String delete = "DELETE FROM " + ConstMedicalInstitution.MedicalInstitution_TABLE +
                " WHERE " + ConstMedicalInstitution.MedicalInstitution_TITLE + "=? ";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(delete);
            preparedStatement.setString(1, medicalInstitution.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public Set<String> getMedsSet() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + ConstMedicalInstitution.MedicalInstitution_TABLE;
        Set<String> set = new HashSet<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                set.add(resultSet.getString("title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    public void signUpMed(MedicalInstitution medicalInstitution) {
        String insert = "INSERT INTO " + ConstMedicalInstitution.MedicalInstitution_TABLE +
                "(" + ConstMedicalInstitution.MedicalInstitution_TITLE + "," +
                ConstMedicalInstitution.MedicalInstitution_PURPOSE + "," +
                ConstMedicalInstitution.MedicalInstitution_TYPE + "," +
                ConstMedicalInstitution.MedicalInstitution_CONTACT_DATA + ")" + "VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setString(1, medicalInstitution.getTitle());
            preparedStatement.setString(2, medicalInstitution.getPurpose());
            preparedStatement.setString(3, medicalInstitution.getType());
            preparedStatement.setString(4, medicalInstitution.getContact_data());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateMed(MedicalInstitution med) {
        String update = "UPDATE " + ConstMedicalInstitution.MedicalInstitution_TABLE + " SET " +
                ConstMedicalInstitution.MedicalInstitution_PURPOSE +"=? " + "," +
                ConstMedicalInstitution.MedicalInstitution_TYPE+ "=? " + "," +
                ConstMedicalInstitution.MedicalInstitution_CONTACT_DATA + "=? " + " WHERE " +
                ConstMedicalInstitution.MedicalInstitution_TITLE+ "=?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(update);
            preparedStatement.setString(1, med.getPurpose());
            preparedStatement.setString(2, med.getType());
            preparedStatement.setString(3, med.getContact_data());
            preparedStatement.setString(4, med.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Profile> getListProfiles() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + ConstProfile.Profile_TABLE;
        ArrayList<Profile> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Profile prof = new Profile();
                prof.setTitle(resultSet.getString("title"));
                arrayList.add(prof);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void deleteProfile(Profile profile) {
        String delete = "DELETE FROM " + ConstProfile.Profile_TABLE +
                " WHERE " + ConstProfile.Profile_TITLE + "=? ";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(delete);
            preparedStatement.setString(1, profile.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public Set<String> getProfilesSet() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + ConstProfile.Profile_TABLE;
        Set<String> set = new HashSet<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                set.add(resultSet.getString("title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    public void signUpProfile(Profile profile) {
        String insert = "INSERT INTO " + ConstProfile.Profile_TABLE + "(" + ConstProfile.Profile_TITLE + ")"
                + "VALUES(?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setString(1, profile.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateProfile(Profile profile) {
        String update = "UPDATE " + ConstProfile.Profile_TABLE + " SET " +
                ConstProfile.Profile_TITLE +"=?" + " WHERE " +
                ConstProfile.Profile_TITLE+ "=?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(update);
            preparedStatement.setString(1, profile.getTitle());
            preparedStatement.setString(2, profile.getOldtitle());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Departament> getListDepartaments() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + ConstDepartaments.DEPARTAMENTS_TABLE;
        ArrayList<Departament> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Departament dep = new Departament();
                dep.setId_med_institutions(resultSet.getInt("id_med_institutions"));
                dep.setTitle(resultSet.getString("title"));
                arrayList.add(dep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void deleteDepartament(Departament dep) {
        String delete = "DELETE FROM " + ConstDepartaments.DEPARTAMENTS_TABLE +
                " WHERE " + ConstDepartaments.DEPARTAMENTS_ID_MED_INSTITUTIONS + "=? AND " +
                ConstDepartaments.DEPARTAMENTS_TITLE + "=?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(delete);
            preparedStatement.setInt(1, dep.getId_med_institutions());
            preparedStatement.setString(2, dep.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public Set<String> getDepsSet() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + ConstDepartaments.DEPARTAMENTS_TABLE;
        Set<String> set = new HashSet<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                set.add(resultSet.getInt(2) + resultSet.getString("title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    public void signUpDepartament(Departament d) {
        String insert = "INSERT INTO " + ConstDepartaments.DEPARTAMENTS_TABLE + "(" +
                ConstDepartaments.DEPARTAMENTS_ID_MED_INSTITUTIONS + ", " + ConstDepartaments.DEPARTAMENTS_TITLE + ")"
                + "VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setInt(1, d.getId_med_institutions());
            preparedStatement.setString(2, d.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateDepartament(Departament departament) {
        String update = "UPDATE " + ConstDepartaments.DEPARTAMENTS_TABLE + " SET " + ConstDepartaments.DEPARTAMENTS_ID_MED_INSTITUTIONS +"=? " + " WHERE " +
                ConstDepartaments.DEPARTAMENTS_TITLE + "=?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(update);
            preparedStatement.setInt(1, departament.getId_med_institutions());
            preparedStatement.setString(2, departament.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Ajainst> getListAjainst() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + ConstAjainst.Ajainst_TABLE;
        ArrayList<Ajainst> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Ajainst ajainst = new Ajainst();
                ajainst.setProfile_id(resultSet.getInt("profile_id"));
                ajainst.setMed_institut_id(resultSet.getInt("med_institut_id"));
                arrayList.add(ajainst);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void deleteAjainst(Ajainst ajainst) {
        String delete = "DELETE FROM " + ConstAjainst.Ajainst_TABLE +
                " WHERE " + ConstAjainst.Ajainst_profile_id+ "=?" + "AND " +
                ConstAjainst.Ajainst_profile_id + "=?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(delete);
            preparedStatement.setInt(1, ajainst.getProfile_id());
            preparedStatement.setInt(2, ajainst.getMed_institut_id());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public Set<String> getAjSet() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + ConstAjainst.Ajainst_TABLE;
        Set<String> set = new HashSet<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                set.add(String.valueOf(resultSet.getInt("profile_id")) +
                        String.valueOf(resultSet.getInt("med_institut_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    public void signUpAjaist(Ajainst ajainst) {
        String insert = "INSERT INTO " + ConstAjainst.Ajainst_TABLE + "(" + ConstAjainst.Ajainst_profile_id + ", " +
                ConstAjainst.Ajainst_med_institut_id + ")" + "VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setInt(1, ajainst.getProfile_id());
            preparedStatement.setInt(2, ajainst.getMed_institut_id());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateAj(Ajainst ajainst) {
        String update = "UPDATE " + ConstAjainst.Ajainst_TABLE + " SET " + ConstAjainst.Ajainst_profile_id +"=? " +
                " WHERE " + ConstAjainst.Ajainst_med_institut_id + "=?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(update);
            preparedStatement.setInt(1, ajainst.getProfile_id());
            preparedStatement.setInt(2, ajainst.getMed_institut_id());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Worker> getListWorkers() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + ConstWorker.WORKER_TABLE;
        ArrayList<Worker> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Worker w = new Worker();
                w.setIdMedical(resultSet.getInt("med_id"));
                w.setName(resultSet.getString("name"));
                w.setSurname(resultSet.getString("surname"));
                w.setPartonynic(resultSet.getString("patronymic"));
                w.setSpecilization(resultSet.getString("specialization"));
                w.setCategoty(resultSet.getString("category"));
                w.setType(resultSet.getString("type"));
                arrayList.add(w);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void deleteWorker(Worker worker) {
        String delete = "DELETE FROM " + ConstWorker.WORKER_TABLE + " WHERE " + ConstWorker.WORKER_ID_MED + "=? AND " +
                ConstWorker.WORKER_NAME + "=? AND " + ConstWorker.WORKER_SURNAME + "=? AND " +
                ConstWorker.WORKER_PATRONYMIC + "=? AND " + ConstWorker.WORKER_SPECIALIZATION + "=? AND " +
                ConstWorker.WORKER_CATEGORY + "=? AND " + ConstWorker.WORKER_TYPE + "=?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(delete);
            preparedStatement.setInt(1, worker.getMed_id());
            preparedStatement.setString(2, worker.getName());
            preparedStatement.setString(3, worker.getSurname());
            preparedStatement.setString(4, worker.getPartonynic());
            preparedStatement.setString(5, worker.getSpecilization());
            preparedStatement.setString(6, worker.getCategoty());
            preparedStatement.setString(7, worker.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public Set<String> getWorkersSet() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + ConstWorker.WORKER_TABLE;
        Set<String> set = new HashSet<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                set.add(resultSet.getString("name") +
                        resultSet.getString("surname") +
                        resultSet.getString("patronymic"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    public void signUpWorker(Worker w) {
        String insert = "INSERT INTO " + ConstWorker.WORKER_TABLE + "(" + ConstWorker.WORKER_ID_MED + "," +
                ConstWorker.WORKER_NAME + "," + ConstWorker.WORKER_SURNAME + "," + ConstWorker.WORKER_PATRONYMIC + "," +
                ConstWorker.WORKER_SPECIALIZATION + "," + ConstWorker.WORKER_CATEGORY + "," + ConstWorker.WORKER_TYPE
                 + ")" +  "VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setInt(1, w.getMed_id());
            preparedStatement.setString(2, w.getName());
            preparedStatement.setString(3, w.getSurname());
            preparedStatement.setString(4, w.getPartonynic());
            preparedStatement.setString(5, w.getSpecilization());
            preparedStatement.setString(6, w.getCategoty());
            preparedStatement.setString(7, w.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateWorker(Worker w) {
        String update = "UPDATE " + ConstWorker.WORKER_TABLE + " SET " + ConstWorker.WORKER_ID_MED +"=? " + "," +
                ConstWorker.WORKER_SPECIALIZATION + "=? " + "," + ConstWorker.WORKER_CATEGORY + "=? " + "," +
                ConstWorker.WORKER_TYPE + "=? " + " WHERE " + ConstWorker.WORKER_NAME + "=? AND " +
                ConstWorker.WORKER_SURNAME + "=? AND " + ConstWorker.WORKER_PATRONYMIC + "=?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(update);
            preparedStatement.setInt(1, w.getMed_id());
            preparedStatement.setString(2, w.getSpecilization());
            preparedStatement.setString(3, w.getCategoty());
            preparedStatement.setString(4, w.getType());
            preparedStatement.setString(5, w.getName());
            preparedStatement.setString(6, w.getSurname());
            preparedStatement.setString(7, w.getPartonynic());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Q1Object> getListQ1s(Q1Object q1) {
        ResultSet resultSet = null;
        String select = "SELECT " + ConstQ1.Q1_specialization + "," + ConstQ1.Q1_TITLE + "," +
                ConstQ1.Q1_NAME  + "," + ConstQ1.Q1_SURNAME + "," + ConstQ1.Q1_PATRONYMIC + " FROM "
                + ConstMedicalInstitution.MedicalInstitution_TABLE + " med" + " INNER JOIN " +
                ConstWorker.WORKER_TABLE + " w" + " ON " + "(" + "med." + "\"" +
                ConstMedicalInstitution.MedicalInstitution_ID + "\"" + "=w." + ConstWorker.WORKER_ID_MED + ")" + "WHERE " +
                ConstQ1.Q1_TITLE + " =" + "'" +q1.getMed() + "'" + " AND " + ConstQ1.Q1_specialization + " =" + "'"+
                q1.getProfile()+ "'";

        ArrayList<Q1Object> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Q1Object q1Object = new Q1Object();
                q1Object.setName(resultSet.getString("name"));
                q1Object.setSurname(resultSet.getString("surname"));
                q1Object.setPatronymic(resultSet.getString("patronymic"));
                q1Object.setMed(q1.getMed());
                q1Object.setProfile(q1.getProfile());
                arrayList.add(q1Object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Q1Object q1Object : arrayList) {
            q1Object.setCount(arrayList.size());
        }
        return arrayList;
    }

    public ArrayList<Q2Object> getListQ2s(Q2Object q2Object) {
        ResultSet resultSet = null;
        String select = "SELECT " + ConstQ1.Q1_specialization + "," + ConstQ1.Q1_TITLE + "," +
                ConstQ1.Q1_NAME  + "," + ConstQ1.Q1_SURNAME + "," + ConstQ1.Q1_PATRONYMIC + "," + " w." + "\"" + "type" +
                "\"" + " FROM " + ConstMedicalInstitution.MedicalInstitution_TABLE + " med" + " INNER JOIN " +
                ConstWorker.WORKER_TABLE + " w" + " ON " + "(" + "med." + "\"" +
                ConstMedicalInstitution.MedicalInstitution_ID +
                "\"" + "=w." + ConstWorker.WORKER_ID_MED + ")" + " WHERE " + ConstQ1.Q1_TITLE + " =" + "'" + q2Object.getMed() +
                "'" + " AND " + "w." +"\"" + "type" + "\"" + " =" + "'"+ q2Object.getType()+ "'" + " AND " +
                ConstQ1.Q1_specialization + " =" + "'"+ q2Object.getSpecialization()+ "'";

        ArrayList<Q2Object> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Q2Object q2 = new Q2Object();
                q2.setName(resultSet.getString("name"));
                q2.setSurname(resultSet.getString("surname"));
                q2.setPatronymic(resultSet.getString("patronymic"));
                q2.setMed(q2Object.getMed());
                q2.setSpecialization(q2Object.getSpecialization());
                q2.setType(q2Object.getType());
                arrayList.add(q2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Q2Object q3 : arrayList) {
            q3.setCount(arrayList.size());
        }
        return arrayList;
    }

    public ArrayList<Q3Object> getListQ3s(Q3Object q3Object) {
        ResultSet resultSet = null;
        String select = "Select med.title, p.name,p.surname,p.patronymic,start_time,health_description,tempriture,wor.name,wor.surname,wor.patronymic From patients p INNER JOIN ward w ON (p.Ward_id=w.wards_id) INNER JOIN departaments d ON " +
                "(d.departaments_id=w.departaments_id) INNER JOIN medical_institutions med ON \n" +
                "(d.id_med_institutions=med.\"idMedical_institutions\") INNER JOIN workers wor ON (p.workers_id=wor.\"idWorkers\")\n" +
                "WHERE med.title = " + "\'" + q3Object.getMed() + "\'";

        ArrayList<Q3Object> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Q3Object q3 = new Q3Object();
                q3.setName(resultSet.getString("name"));
                q3.setSurname(resultSet.getString("surname"));
                q3.setPatronymic(resultSet.getString("patronymic"));
                q3.setMed(q3Object.getMed());
                q3.setDate(resultSet.getDate("start_time"));
                q3.setHealth(resultSet.getString("health_description"));
                q3.setTemperature(resultSet.getInt("tempriture"));
                q3.setDocname(resultSet.getString(8));
                q3.setDocsurname(resultSet.getString(9));
                q3.setDocpatronymic(resultSet.getString(10));
                arrayList.add(q3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<Q4Object> getListQ4s(Q4Object q4Object) {
        ResultSet resultSet = null;
        String select = "Select med.title, start_time, end_time, p.name, p.surname, p.patronymic From patients p INNER JOIN ward w ON (p.Ward_id=w.wards_id) INNER JOIN departaments d ON " +
                "(d.departaments_id=w.departaments_id) INNER JOIN medical_institutions med ON " +
                "(d.id_med_institutions=med.\"idMedical_institutions\") INNER JOIN workers wor ON (p.workers_id=wor.\"idWorkers\")" +
                "WHERE med.title =" + "'" + q4Object.getMed() + "'" + " AND start_time > " + "'" + q4Object.getStart_date()+ "'" + " AND end_time < " + "'" + q4Object.getEnd_date() + "'";

        ArrayList<Q4Object> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Q4Object q4 = new Q4Object();
                q4.setMed(q4Object.getMed());
                q4.setStart_date(resultSet.getDate(2));
                q4.setEnd_date(resultSet.getDate(3));
                q4.setName(resultSet.getString(4));
                q4.setSurname(resultSet.getString(5));
                q4.setPatronymic(resultSet.getString(6));
                arrayList.add(q4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<Q5Object> getListQ5s(Q5Object q5Object) {
        ResultSet resultSet = null;
        String select = "Select p.name, p.surname, p.patronymic, med.title From patients p INNER JOIN ward w ON (p.Ward_id=w.wards_id) " +
                "INNER JOIN departaments d ON (d.departaments_id=w.departaments_id) INNER JOIN medical_institutions med ON " +
                "(d.id_med_institutions=med.\"idMedical_institutions\") INNER JOIN workers wor ON (p.workers_id=wor.\"idWorkers\")" +
                "WHERE med.title = " + "'" + q5Object.getMed() + "'" + " AND specialization = " + "'" + q5Object.getProf() + "'";


        ArrayList<Q5Object> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Q5Object q5 = new Q5Object();
                q5.setMed(q5Object.getMed());
                q5.setProf(q5Object.getProf());
                q5.setName(resultSet.getString(1));
                q5.setSurname(resultSet.getString(2));
                q5.setPatronymic(resultSet.getString(3));
                arrayList.add(q5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
