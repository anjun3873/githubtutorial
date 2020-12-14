package com.elsys.scheduler.web;

import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.python.icu.text.DateFormat;
import org.python.icu.text.SimpleDateFormat;
import org.python.icu.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.elsys.common.utils.StaticVO;
import com.elsys.scheduler.service.PcsEssTaskService;


@Controller("PcsEssTask")
public class PcsEssTask {
	
	protected StaticVO staticVO = new StaticVO();

	@Resource(name="pcsEssTaskService")
	private PcsEssTaskService pcsEssTaskService;

	private static final Logger log = LoggerFactory.getLogger(PcsEssTask.class);

	/**
	 * API를 통해 PCS-ESS 순시 데이터 가져오기
	 * @throws Exception
	 */
	public void pcsEssData() throws Exception { 
		
		if (log.isDebugEnabled()) {
			log.debug("==========================================================================================");
			log.debug("= smpData -- Batch Job Execution on basis the scheduler... =");
			log.debug("==========================================================================================");
		}
		
		
		try {
			System.out.println("pcsEss 스케줄러 ");
			
			ArrayList<HashMap<String,Object>> houseIdList = new ArrayList<HashMap<String,Object>>();
			HashMap<String,Object> dataMap = new HashMap<String,Object>();
			//houseIdList = pcsEssTaskService.getHouseIdList(dataMap); // 세대 리스트 가져오기 위해 선언
			
			// 세대 수 만큼 for 돌림
			//for(int i=0; i < houseIdList.size(); i++){
				//String houseId = houseIdList.get(i).get("HOUSE_ID").toString();
				String houseId = "Yongin_Raemian_101_603";
				
				/*URL url = new URL("http://101.55.126.224/Hems/"+houseId+"/PCS_ESS/DATA/latest");
	        	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        	conn.setDoOutput(true);
	        	
	        	conn.setRequestMethod("GET");
	        	conn.setRequestProperty("X-M2M-RI", "12345");
	        	conn.setRequestProperty("accept", "application/vnd.onem2m-prsp+json");
	        	conn.setRequestProperty("X-M2M-Origin", "SOrigin");
	        	
	        	if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	            }
	        	
	        	
	        	JSONObject connObj = new JSONObject();
	        	connObj = (JSONObject)JSONValue.parse(new InputStreamReader(conn.getInputStream()));
	        	
	        	JSONObject m2mCin = (JSONObject) connObj.get("m2m:cin");*/
	        	
	        	/**
	        	 * API에서 받아온 UTC 날짜 date를 변환 작업
	        	 */
	        	/*String ltDate = m2mCin.get("lt").toString();
	        	
	        	String eventTimeKo = "";
	        	
	        	DateFormat inDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
	            inDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
	            //outDate
	            SimpleDateFormat outDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            eventTimeKo = outDateFormat.format(inDateFormat.parse(ltDate));*/
	        	
	        	// 변환 작업 끝
	        	
	          /*  JSONObject jobCon = (JSONObject) m2mCin.get("con");
	            JSONObject jobResult = (JSONObject) jobCon.get("results");
	            
	            */
	            HashMap<String, Object> paramMap = new HashMap<String,Object>();
	            
	            /*
	            // jsonData PARSING S
	            JSONObject gen_eng_total = (JSONObject) jobResult.get("generated_energy_total");
	            JSONObject gen_eng_year = (JSONObject) jobResult.get("generated_energy_year");
	            JSONObject gen_eng_month = (JSONObject) jobResult.get("generated_energy_month");
	            JSONObject gen_eng_day = (JSONObject) jobResult.get("generated_energy_day");
	            JSONObject rat_ac_in_rat_volt = (JSONObject) jobResult.get("rated_AC_input_rating_voltage");
	            JSONObject rat_ac_in_rat_current = (JSONObject) jobResult.get("rated_AC_input_rating_current");
	            JSONObject rat_ac_out_rat_volt = (JSONObject) jobResult.get("rated_AC_output_rating_voltage");
	            JSONObject rat_ac_out_rat_freqy = (JSONObject) jobResult.get("rated_AC_output_rating_frequency");
	            JSONObject rat_ac_out_rat_current = (JSONObject) jobResult.get("rated_AC_output_rating_current");
	            JSONObject rat_ac_out_rat_appar_pow = (JSONObject) jobResult.get("rated_AC_output_rating_apparent_power");
	            JSONObject rat_ac_out_rat_active_pow = (JSONObject) jobResult.get("rated_AC_output_rating_active_power");
	            JSONObject rat_bat_rat_volt = (JSONObject) jobResult.get("rated_Battery_rating_voltage");
	            JSONObject rat_bat_re_charg_volt = (JSONObject) jobResult.get("rated_Battery_re_charge_voltage");
	            JSONObject rat_bat_re_discharg_volt = (JSONObject) jobResult.get("rated_Battery_re_discharge_voltage");
	            JSONObject rat_bat_under_volt = (JSONObject) jobResult.get("rated_Battery_under_voltage");
	            JSONObject rat_bat_bulk_volt = (JSONObject) jobResult.get("rated_Battery_bulk_voltage");
	            JSONObject rat_bat_float_volt = (JSONObject) jobResult.get("rated_Battery_float_voltage");
	            JSONObject rat_max_ac_charg_current = (JSONObject) jobResult.get("rated_Max_AC_charging_current");
	            JSONObject rat_max_charg_current = (JSONObject) jobResult.get("rated_Max_charging_current");
	            JSONObject rat_in_volt_range = (JSONObject) jobResult.get("rated_Input_voltage_range");
	            JSONObject rat_out_source_prior = (JSONObject) jobResult.get("rated_Output_source_priority");
	            JSONObject rat_charg_source_prior = (JSONObject) jobResult.get("rated_Charger_source_priority");
	            JSONObject rat_machine_type = (JSONObject) jobResult.get("rated_Machine_type");
	            JSONObject rat_topology = (JSONObject) jobResult.get("rated_Topology");
	            JSONObject rat_out_model_set = (JSONObject) jobResult.get("rated_Output_model_setting");
	            JSONObject rat_solar_pow_prior = (JSONObject) jobResult.get("rated_Solar_power_priority");
	            JSONObject rat_mppt_string = (JSONObject) jobResult.get("rated_MPPT_string");
	            JSONObject gen_grid_volt = (JSONObject) jobResult.get("general_Grid_voltage");
	            JSONObject gen_grid_freqy = (JSONObject) jobResult.get("general_Grid_frequency");
	            JSONObject gen_ac_out_volt = (JSONObject) jobResult.get("general_AC_output_voltage");
	            JSONObject gen_ac_out_freqy = (JSONObject) jobResult.get("general_AC_output_frequency");
	            JSONObject gen_ac_out_appar_pow = (JSONObject) jobResult.get("general_AC_output_apparent_power");
	            JSONObject gen_ac_out_active_pow = (JSONObject) jobResult.get("general_AC_output_active_power");
	            JSONObject gen_out_load_percent = (JSONObject) jobResult.get("general_Output_load_percent");
	            JSONObject gen_bat_volt = (JSONObject) jobResult.get("general_Battery_voltage");
	            JSONObject gen_bat_volt_from_scc = (JSONObject) jobResult.get("general_Battery_voltage_from_SCC");
	            JSONObject gen_bat_volt_from_scc2 = (JSONObject) jobResult.get("general_Battery_voltage_from_SCC2");
	            JSONObject gen_bat_discharg_current = (JSONObject) jobResult.get("general_Battery_discharge_current");
	            JSONObject gen_bat_charg_current = (JSONObject) jobResult.get("general_Battery_charging_current");
	            JSONObject gen_bat_capacity = (JSONObject) jobResult.get("general_Battery_capacity");
	            JSONObject gen_ivt_heat_sink_temp = (JSONObject) jobResult.get("general_Inverter_heat_sink_temperature");
	            JSONObject gen_mppt1_charg_temp = (JSONObject) jobResult.get("general_MPPT1_charger_temperature");
	            JSONObject gen_mppt2_charg_temp = (JSONObject) jobResult.get("general_MPPT2_charger_temperature");
	            JSONObject gen_pv1_in_pow = (JSONObject) jobResult.get("general_PV1_Input_power");
	            JSONObject gen_pv2_in_pow = (JSONObject) jobResult.get("general_PV2_Input_power");
	            JSONObject gen_pv1_in_volt = (JSONObject) jobResult.get("general_PV1_Input_voltage");
	            JSONObject gen_pv2_in_volt = (JSONObject) jobResult.get("general_PV2_Input_voltage");
	            JSONObject gen_set_val_configura_state = (JSONObject) jobResult.get("general_Setting_value_configuration_state");
	            JSONObject gen_load_conn = (JSONObject) jobResult.get("general_Load_connection");
	            JSONObject gen_bat_pow_direct = (JSONObject) jobResult.get("general_Battery_power_direction");
	            JSONObject gen_dc_ac_pow_direct = (JSONObject) jobResult.get("general_DC_AC_power_direction");
	            JSONObject gen_line_pow_direct = (JSONObject) jobResult.get("general_Line_power_direction");
	            JSONObject working_mode = (JSONObject) jobResult.get("working_mode");
	            
	            // 4차년도 dataMap
	            paramMap.put("house_id", houseId);
	            paramMap.put("reg_dt", eventTimeKo);
	            paramMap.put("pcs_hess_run_state", ICreateRandom);
	            paramMap.put("pcs_auto_mode_state", ICreateRandom);
	            paramMap.put("pcs_state", ICreateRandom);
	            paramMap.put("pcs_fault_reset_state", ICreateRandom);
	            paramMap.put("pcs_bat_dc_limit_curr", rat_ac_in_rat_volt.get("value"));
	            paramMap.put("pcs_bat_rat_volt", rat_ac_in_rat_current.get("value"));
	            paramMap.put("pcs_bat_fault_volt", rat_ac_out_rat_volt.get("value"));
	            paramMap.put("pcs_bat_fc_volt", rat_ac_out_rat_freqy.get("value"));
	            paramMap.put("pcs_bat_soc", rat_ac_out_rat_current.get("value"));
	            paramMap.put("pcs_bat_dc_volt", rat_ac_out_rat_appar_pow.get("value"));
	            paramMap.put("pcs_bat_max_soc", rat_ac_out_rat_active_pow.get("value")); // 최대값
	            paramMap.put("pcs_bat_min_soc", rat_bat_rat_volt.get("value"));
	            paramMap.put("pcs_grid_volt", rat_bat_re_charg_volt.get("value"));
	            paramMap.put("pcs_grid_curr", rat_bat_re_discharg_volt.get("value"));
	            paramMap.put("pcs_grid_freq", rat_bat_under_volt.get("value"));
	            paramMap.put("pcs_bat_volt", rat_bat_bulk_volt.get("value"));
	            paramMap.put("pcs_bat_curr", rat_bat_float_volt.get("value"));
	            paramMap.put("pcs_pv_voltage", rat_max_ac_charg_current.get("value"));
	            paramMap.put("pcs_pv_curr", rat_max_charg_current.get("value"));
	            paramMap.put("pcs_temp", rat_in_volt_range.get("value"));
	            paramMap.put("pcs_inv_c_power", rat_out_source_prior.get("value"));
	            paramMap.put("pcs_inv_dc_power", rat_charg_source_prior.get("value"));
	            paramMap.put("pcs_pv_power", rat_machine_type.get("value"));
	            paramMap.put("pcs_bat_c_power", rat_topology.get("value"));
	            paramMap.put("pcs_bat_dc_power", rat_out_model_set.get("value"));
	            paramMap.put("pcs_total_state", rat_solar_pow_prior.get("value"));
	            paramMap.put("pcs_warn_state", rat_mppt_string.get("value"));
	            paramMap.put("ess_cell_volt_1", gen_grid_volt.get("value"));
	            paramMap.put("ess_cell_volt_2", gen_grid_freqy.get("value"));
	            paramMap.put("ess_cell_volt_3", gen_ac_out_volt.get("value"));
	            paramMap.put("ess_cell_volt_4", gen_ac_out_freqy.get("value"));
	            paramMap.put("ess_cell_volt_5", gen_ac_out_appar_pow.get("value"));
	            paramMap.put("ess_cell_volt_6", gen_ac_out_active_pow.get("value"));
	            paramMap.put("ess_cell_volt_7", gen_out_load_percent.get("value"));
	            paramMap.put("ess_cell_volt_8", gen_bat_volt.get("value"));
	            paramMap.put("ess_cell_volt_9", gen_bat_volt_from_scc.get("value"));
	            paramMap.put("ess_cell_volt_10", gen_bat_volt_from_scc2.get("value"));
	            paramMap.put("ess_cell_volt_11", gen_bat_discharg_current.get("value"));
	            paramMap.put("ess_cell_volt_12", gen_bat_charg_current.get("value"));
	            paramMap.put("ess_cell_volt_13", gen_bat_capacity.get("value"));
	            paramMap.put("ess_cell_volt_14", gen_ivt_heat_sink_temp.get("value"));
	            paramMap.put("ess_cell_volt_15", gen_mppt1_charg_temp.get("value"));
	            paramMap.put("ess_cell_volt_16", gen_mppt2_charg_temp.get("value"));
	            paramMap.put("ess_temp_1", gen_pv1_in_pow.get("value"));
	            paramMap.put("ess_temp_2", gen_pv2_in_pow.get("value"));
	            paramMap.put("ess_temp_3", gen_pv1_in_volt.get("value"));
	            paramMap.put("ess_temp_4", gen_pv2_in_volt.get("value"));
	            paramMap.put("ess_temp_5", gen_set_val_configura_state.get("value"));
	            paramMap.put("ess_temp_6", gen_load_conn.get("value"));
	            paramMap.put("ess_temp_7", gen_bat_pow_direct.get("value"));
	            paramMap.put("ess_temp_8", gen_dc_ac_pow_direct.get("value"));
	            paramMap.put("ess_volt", gen_line_pow_direct.get("value"));
	            paramMap.put("ess_curr", working_mode.get("value"));
	            paramMap.put("ess_ram_bat", def_ac_out_volt.get("value"));
	            paramMap.put("ess_full_bat", def_ac_out_freqy.get("value"));
	            paramMap.put("ess_soc", def_bat_under_volt.get("value"));
	            paramMap.put("ess_soh", def_charg_float_volt.get("value"));
	            paramMap.put("ess_cycle_time", def_charg_bulk_volt.get("value"));
	            paramMap.put("ess_max_cell_volt", def_bat_def_re_charg_volt.get("value"));
	            paramMap.put("ess_max_cell_volt_num", def_bat_re_discharg_volt.get("value"));
	            paramMap.put("ess_min_cell_volt", def_max_charg_current.get("value"));
	            paramMap.put("ess_min_cell_volt_num", def_max_ac_charg_current.get("value"));
	            paramMap.put("ess_avg_cell_volt", def_bat_type.get("value"));
	            paramMap.put("ess_max_cell_temp", def_out_source_prior.get("value"));
	            paramMap.put("ess_cell_temp_diff_num", def_charg_source_prior.get("value"));
	            paramMap.put("ess_min_cell_temp", def_solar_pow_prior.get("value"));
	            paramMap.put("ess_cell_volt_diff_num", def_out_model_set.get("value"));
	            paramMap.put("ess_num_of_bat_cell", def_out_model_set.get("value"));
	            paramMap.put("ess_mos_temp_sense", def_out_model_set.get("value"));
	            paramMap.put("ess_quan_of_envl_temp", def_out_model_set.get("value"));
	            paramMap.put("ess_num_of_bat_str", def_out_model_set.get("value"));
	            paramMap.put("ess_total_temp", def_out_model_set.get("value"));
	            paramMap.put("ess_balance_mode", def_out_model_set.get("value"));
	            paramMap.put("ess_balance_status", def_out_model_set.get("value"));
	            paramMap.put("ess_balance_info_1", def_out_model_set.get("value"));
	            paramMap.put("ess_balance_info_2", def_out_model_set.get("value"));
	            paramMap.put("ess_balance_info_3", def_out_model_set.get("value"));
	            paramMap.put("ess_balance_info_4", def_out_model_set.get("value"));
	            paramMap.put("ess_protec_status_1", def_out_model_set.get("value"));
	            paramMap.put("ess_protec_status_2", def_out_model_set.get("value"));
	            paramMap.put("ess_protec_status_3", def_out_model_set.get("value"));
	            paramMap.put("ess_protec_status_4", def_out_model_set.get("value"));
	            
	            // null 값 체크(평소에는 들어오지 않는 값들, 에러가 터질때만 값 들어옴) S
	            if(isNull(jobResult.get("Fault_code")) == false){
	            	paramMap.put("fault_code", null);
	            }else{
	            	JSONObject fault_code = (JSONObject) jobResult.get("Fault_code");
	            	paramMap.put("fault_code", fault_code.get("value"));
	            }
	            
	            if(isNull(jobResult.get("Line_fail")) == false){
	            	paramMap.put("line_fail", null);
	            }else{
	            	JSONObject line_fail = (JSONObject) jobResult.get("Line_fail");
	            	paramMap.put("line_fail", line_fail.get("value"));
	            }
	            
	            if(isNull(jobResult.get("Output_circuit_short")) == false){
	            	paramMap.put("out_circuit_short", null);
	            }else{
	            	JSONObject out_circuit_short = (JSONObject) jobResult.get("Output_circuit_short");
	            	paramMap.put("out_circuit_short", out_circuit_short.get("value"));
	            }
	            
	            if(isNull(jobResult.get("Inverter_over_temperature")) == false){
	            	paramMap.put("ivt_over_temp", null);
	            }else{
	            	JSONObject ivt_over_temp = (JSONObject) jobResult.get("Inverter_over_temperature");
	            	paramMap.put("ivt_over_temp", ivt_over_temp.get("value"));
	            }
	            
	            if(isNull(jobResult.get("Fan_lock")) == false){
	            	paramMap.put("fan_lock", null);
	            }else{
	            	JSONObject fan_lock = (JSONObject) jobResult.get("Fan_lock");
	            	paramMap.put("fan_lock", fan_lock.get("value"));
	            }
	            
	            if(isNull(jobResult.get("Battery_voltage_high")) == false){
	            	paramMap.put("bat_volt_high", null);
	            }else{
	            	JSONObject bat_volt_high = (JSONObject) jobResult.get("Battery_voltage_high");
	            	paramMap.put("bat_volt_high", bat_volt_high.get("value"));
	            }
	            
	            if(isNull(jobResult.get("Battery_low")) == false){
	            	paramMap.put("bat_low", null);
	            }else{
	            	JSONObject bat_low = (JSONObject) jobResult.get("Battery_low");
	            	paramMap.put("bat_low", bat_low.get("value"));
	            }
	            
	            if(isNull(jobResult.get("Battery_under")) == false){
	            	paramMap.put("bat_under", null);
	            }else{
	            	JSONObject bat_under = (JSONObject) jobResult.get("Battery_under");
	            	paramMap.put("bat_under", bat_under.get("value"));
	            }
	            
	            if(isNull(jobResult.get("Over_load")) == false){
	            	paramMap.put("over_load", null);
	            }else{
	            	JSONObject over_load = (JSONObject) jobResult.get("Over_load");
	            	paramMap.put("over_load", over_load.get("value"));
	            }
	            
	            if(isNull(jobResult.get("Eeprom_fail")) == false){
	            	paramMap.put("eeprom_fail", null);
	            }else{
	            	JSONObject eeprom_fail = (JSONObject) jobResult.get("Eeprom_fail");
	            	paramMap.put("eeprom_fail", eeprom_fail.get("value"));
	            }
	            
	            if(isNull(jobResult.get("Power_limit")) == false){
	            	paramMap.put("pow_limit", null);
	            }else{
	            	JSONObject pow_limit = (JSONObject) jobResult.get("Power_limit");
	            	paramMap.put("pow_limit", pow_limit.get("value"));
	            }
	            
	            if(isNull(jobResult.get("PV1_voltage_high")) == false){
	            	paramMap.put("pv1_volt_high", null);
	            }else{
	            	JSONObject pv1_volt_high = (JSONObject) jobResult.get("PV1_voltage_high");
	            	paramMap.put("pv1_volt_high", pv1_volt_high.get("value"));
	            }
	            
	            if(isNull(jobResult.get("PV2_voltage_high")) == false){
	            	paramMap.put("pv2_volt_high", null);
	            }else{
	            	JSONObject pv2_volt_high = (JSONObject) jobResult.get("PV2_voltage_high");
	            	paramMap.put("pv2_volt_high", pv2_volt_high.get("value"));
	            }
	            
	            if(isNull(jobResult.get("MPPT1_overload_warning")) == false){
	            	paramMap.put("mppt1_overload_warn", null);
	            }else{
	            	JSONObject mppt1_overload_warn = (JSONObject) jobResult.get("MPPT1_overload_warning");
	            	paramMap.put("mppt1_overload_warn", mppt1_overload_warn.get("value"));
	            }
	            
	            if(isNull(jobResult.get("MPPT2_overload_warning")) == false){
	            	paramMap.put("mppt2_overload_warn", null);
	            }else{
	            	JSONObject mppt2_overload_warn = (JSONObject) jobResult.get("MPPT2_overload_warning");
	            	paramMap.put("mppt2_overload_warn", mppt2_overload_warn.get("value"));
	            }
	            
	            if(isNull(jobResult.get("Battery_too_low_to_charge_for_SCC1")) == false){
	            	paramMap.put("bat_too_low_to_charg_for_scc1", null);
	            }else{
	            	JSONObject bat_too_low_to_charg_for_scc1 = (JSONObject) jobResult.get("Battery_too_low_to_charge_for_SCC1");
	            	paramMap.put("bat_too_low_to_charg_for_scc1", bat_too_low_to_charg_for_scc1.get("value"));
	            }
	            
	            if(isNull(jobResult.get("Battery_too_low_to_charge_for_SCC2")) == false){
	            	paramMap.put("bat_too_low_to_charg_for_scc2", null);
	            }else{
	            	JSONObject bat_too_low_to_charg_for_scc2 = (JSONObject) jobResult.get("Battery_too_low_to_charge_for_SCC2");
	            	paramMap.put("bat_too_low_to_charg_for_scc2", bat_too_low_to_charg_for_scc2.get("value"));
	            }
	            // null 값 체크 E
	            
	            JSONObject def_ac_out_volt = (JSONObject) jobResult.get("default_AC_output_voltage");
	            JSONObject def_ac_out_freqy = (JSONObject) jobResult.get("default_AC_output_frequency");
	            JSONObject def_bat_under_volt = (JSONObject) jobResult.get("default_Battery_Under_voltage");
	            JSONObject def_charg_float_volt = (JSONObject) jobResult.get("default_Charging_float_voltage");
	            JSONObject def_charg_bulk_volt = (JSONObject) jobResult.get("default_Charging_bulk_voltage");
	            JSONObject def_bat_def_re_charg_volt = (JSONObject) jobResult.get("default_Battery_default_re_charge_voltage");
	            JSONObject def_bat_re_discharg_volt = (JSONObject) jobResult.get("default_Battery_re_discharge_voltage");
	            JSONObject def_max_charg_current = (JSONObject) jobResult.get("default_Max_charging_current");
	            JSONObject def_max_ac_charg_current = (JSONObject) jobResult.get("default_Max_AC_charging_current");
	            JSONObject def_bat_type = (JSONObject) jobResult.get("default_Battery_type");
	            JSONObject def_out_source_prior = (JSONObject) jobResult.get("default_Output_source_priority");
	            JSONObject def_charg_source_prior = (JSONObject) jobResult.get("default_Charger_source_priority");
	            JSONObject def_solar_pow_prior = (JSONObject) jobResult.get("default_Solar_power_priority");
	            JSONObject def_out_model_set = (JSONObject) jobResult.get("default_Output_model_setting");
	            // jsonData PARSING E
	            
	            // 충전량, 방전량 계산 S
	            double dobGBV = Double.valueOf(gen_bat_volt.get("value").toString()); // 배터리전압
	            double dobGBCC = Double.valueOf(gen_bat_charg_current.get("value").toString()); // 배터리 충전 전류
	            double dobGBDC = Double.valueOf(gen_bat_discharg_current.get("value").toString()); // 배터리 방전 전류
	            
	            double dobCharge = dobGBV * dobGBCC; // 충전량(배터리전압 * 배터리 충전전류)
	            double dobDischarge = dobGBV * dobGBDC; // 방전량(배터리전압 * 배터리 방전전류)
	            
	            String charge = String.valueOf(dobCharge);
	            String discharge = String.valueOf(dobDischarge);
	            
	            paramMap.put("charge", charge);
	            paramMap.put("discharge", discharge);
	            // 충전량, 방전량 계산 E
	            
	            paramMap.put("house_id", houseId);
	            paramMap.put("reg_dt", eventTimeKo);
	            paramMap.put("gen_eng_total", gen_eng_total.get("value"));
	            paramMap.put("gen_eng_year", gen_eng_year.get("value"));
	            paramMap.put("gen_eng_month", gen_eng_month.get("value"));
	            paramMap.put("gen_eng_day", gen_eng_day.get("value"));
	            paramMap.put("rat_ac_in_rat_volt", rat_ac_in_rat_volt.get("value"));
	            paramMap.put("rat_ac_in_rat_current", rat_ac_in_rat_current.get("value"));
	            paramMap.put("rat_ac_out_rat_volt", rat_ac_out_rat_volt.get("value"));
	            paramMap.put("rat_ac_out_rat_freqy", rat_ac_out_rat_freqy.get("value"));
	            paramMap.put("rat_ac_out_rat_current", rat_ac_out_rat_current.get("value"));
	            paramMap.put("rat_ac_out_rat_appar_pow", rat_ac_out_rat_appar_pow.get("value"));
	            paramMap.put("rat_ac_out_rat_active_pow", rat_ac_out_rat_active_pow.get("value"));
	            paramMap.put("rat_bat_rat_volt", rat_bat_rat_volt.get("value"));
	            paramMap.put("rat_bat_re_charg_volt", rat_bat_re_charg_volt.get("value"));
	            paramMap.put("rat_bat_re_discharg_volt", rat_bat_re_discharg_volt.get("value"));
	            paramMap.put("rat_bat_under_volt", rat_bat_under_volt.get("value"));
	            paramMap.put("rat_bat_bulk_volt", rat_bat_bulk_volt.get("value"));
	            paramMap.put("rat_bat_float_volt", rat_bat_float_volt.get("value"));
	            paramMap.put("rat_max_ac_charg_current", rat_max_ac_charg_current.get("value"));
	            paramMap.put("rat_max_charg_current", rat_max_charg_current.get("value"));
	            paramMap.put("rat_in_volt_range", rat_in_volt_range.get("value"));
	            paramMap.put("rat_out_source_prior", rat_out_source_prior.get("value"));
	            paramMap.put("rat_charg_source_prior", rat_charg_source_prior.get("value"));
	            paramMap.put("rat_machine_type", rat_machine_type.get("value"));
	            paramMap.put("rat_topology", rat_topology.get("value"));
	            paramMap.put("rat_out_model_set", rat_out_model_set.get("value"));
	            paramMap.put("rat_solar_pow_prior", rat_solar_pow_prior.get("value"));
	            paramMap.put("rat_mppt_string", rat_mppt_string.get("value"));
	            paramMap.put("gen_grid_volt", gen_grid_volt.get("value"));
	            paramMap.put("gen_grid_freqy", gen_grid_freqy.get("value"));
	            paramMap.put("gen_ac_out_volt", gen_ac_out_volt.get("value"));
	            paramMap.put("gen_ac_out_freqy", gen_ac_out_freqy.get("value"));
	            paramMap.put("gen_ac_out_appar_pow", gen_ac_out_appar_pow.get("value"));
	            paramMap.put("gen_ac_out_active_pow", gen_ac_out_active_pow.get("value"));
	            paramMap.put("gen_out_load_percent", gen_out_load_percent.get("value"));
	            paramMap.put("gen_bat_volt", gen_bat_volt.get("value"));
	            paramMap.put("gen_bat_volt_from_scc", gen_bat_volt_from_scc.get("value"));
	            paramMap.put("gen_bat_volt_from_scc2", gen_bat_volt_from_scc2.get("value"));
	            paramMap.put("gen_bat_discharg_current", gen_bat_discharg_current.get("value"));
	            paramMap.put("gen_bat_charg_current", gen_bat_charg_current.get("value"));
	            paramMap.put("gen_bat_capacity", gen_bat_capacity.get("value"));
	            paramMap.put("gen_ivt_heat_sink_temp", gen_ivt_heat_sink_temp.get("value"));
	            paramMap.put("gen_mppt1_charg_temp", gen_mppt1_charg_temp.get("value"));
	            paramMap.put("gen_mppt2_charg_temp", gen_mppt2_charg_temp.get("value"));
	            paramMap.put("gen_pv1_in_pow", gen_pv1_in_pow.get("value"));
	            paramMap.put("gen_pv2_in_pow", gen_pv2_in_pow.get("value"));
	            paramMap.put("gen_pv1_in_volt", gen_pv1_in_volt.get("value"));
	            paramMap.put("gen_pv2_in_volt", gen_pv2_in_volt.get("value"));
	            paramMap.put("gen_set_val_configura_state", gen_set_val_configura_state.get("value"));
	            paramMap.put("gen_load_conn", gen_load_conn.get("value"));
	            paramMap.put("gen_bat_pow_direct", gen_bat_pow_direct.get("value"));
	            paramMap.put("gen_dc_ac_pow_direct", gen_dc_ac_pow_direct.get("value"));
	            paramMap.put("gen_line_pow_direct", gen_line_pow_direct.get("value"));
	            paramMap.put("working_mode", working_mode.get("value"));
	            paramMap.put("def_ac_out_volt", def_ac_out_volt.get("value"));
	            paramMap.put("def_ac_out_freqy", def_ac_out_freqy.get("value"));
	            paramMap.put("def_bat_under_volt", def_bat_under_volt.get("value"));
	            paramMap.put("def_charg_float_volt", def_charg_float_volt.get("value"));
	            paramMap.put("def_charg_bulk_volt", def_charg_bulk_volt.get("value"));
	            paramMap.put("def_bat_def_re_charg_volt", def_bat_def_re_charg_volt.get("value"));
	            paramMap.put("def_bat_re_discharg_volt", def_bat_re_discharg_volt.get("value"));
	            paramMap.put("def_max_charg_current", def_max_charg_current.get("value"));
	            paramMap.put("def_max_ac_charg_current", def_max_ac_charg_current.get("value"));
	            paramMap.put("def_bat_type", def_bat_type.get("value"));
	            paramMap.put("def_out_source_prior", def_out_source_prior.get("value"));
	            paramMap.put("def_charg_source_prior", def_charg_source_prior.get("value"));
	            paramMap.put("def_solar_pow_prior", def_solar_pow_prior.get("value"));
	            paramMap.put("def_out_model_set", def_out_model_set.get("value"));*/
	            
	            paramMap.put("house_id", houseId);
	            pcsEssTaskService.insertPcsEss(paramMap);
			//}
            
		} catch(Exception err) {
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= Batch Process : Query Execution Error - [{}], [{}] =", err.getLocalizedMessage(), err);
				log.debug("==========================================================================================");
			}
		}finally{
		
		}
		
	}
	
	/**
	 * PCS-ESS 순시데이터 현재날짜기준 3일전 데이터 삭제
	 * @throws Exception
	 */
	public void pcsEssDataDel() throws Exception { 
		
		if (log.isDebugEnabled()) {
			log.debug("==========================================================================================");
			log.debug("= smpData -- Batch Job Execution on basis the scheduler... =");
			log.debug("==========================================================================================");
		}
		
		
		try {
			System.out.println("pcsEss 3일전 데이터 삭제 스케줄러 ");
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			pcsEssTaskService.delPcsEssData(paramMap);
			
            
		} catch(Exception err) {
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= Batch Process : Query Execution Error - [{}], [{}] =", err.getLocalizedMessage(), err);
				log.debug("==========================================================================================");
			}
		}
		
	}
	
	// object null 체크
	public static Boolean empty(Object obj) {
	  if (obj instanceof String) return obj == null || "".equals(obj.toString().trim());
	  else if (obj instanceof List) return obj == null || ((List) obj).isEmpty();
	  else if (obj instanceof Map) return obj == null || ((Map) obj).isEmpty();
	  else if (obj instanceof Object[]) return obj == null || Array.getLength(obj) == 0;
	  else return obj == null;
	 }
	
	// object null 체크 후 결과 값 반환 (true or false)
	 public static boolean isNull(Object obj) {
	     return !empty(obj);
	 }

}
