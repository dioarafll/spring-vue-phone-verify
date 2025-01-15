

import { defineStore } from 'pinia';
import apiClient from '../utils/axios';

/**
 * State dan aksi untuk verifikasi.
 */
export const useVerificationStore = defineStore('verification', {
  state: () => ({
    status: '',
    message: '',
  }),

  actions: {
    /**
     * Mengirimkan kode verifikasi ke nomor telepon.
     * 
     * @param {string} phoneNumber - Nomor telepon yang akan dikirimkan kode verifikasi.
     * @param {string} channel - Channel pengiriman (misalnya, "sms").
     * @returns {Promise<void>}
     */
    async sendVerification(phoneNumber: string, channel: string): Promise<void> {
      try {
        const response = await apiClient.post('/api/verification/send', {
          phoneNumber,
          channel,
        });
        this.status = response.data.status;
        this.message = response.data.message;
      } catch (error) {
        console.error('Error sending verification:', error);
        this.status = 'error';
        this.message = error.response?.data?.message || 'Unknown error';
      }
    },

    /**
     * Memverifikasi kode yang dikirimkan ke nomor telepon.
     * 
     * @param {string} phoneNumber - Nomor telepon yang diverifikasi.
     * @param {string} code - Kode verifikasi yang diterima pengguna.
     * @returns {Promise<void>}
     */
    async verifyCode(phoneNumber: string, code: string): Promise<void> {
      try {
        const response = await apiClient.post('/api/verification/verify', {
          phoneNumber,
          code,
        });
        this.status = response.data.status;
        this.message = response.data.message;
      } catch (error) {
        console.error('Error verifying code:', error);
        this.status = 'error';
        this.message = error.response?.data?.message || 'Unknown error';
      }
    },
  },
});
