

import { useVerificationStore } from '../stores/verificationStore';

/**
 * Hook untuk menggunakan store verifikasi.
 * 
 * @returns {object} Metode dan state dari verification store.
 */
export function useVerification() {
  const store = useVerificationStore();

  /**
   * Mengirimkan kode verifikasi.
   * 
   * @param {string} phoneNumber - Nomor telepon yang akan dikirimkan kode.
   * @param {string} channel - Channel pengiriman.
   */
  const sendVerification = async (phoneNumber: string, channel: string) => {
    await store.sendVerification(phoneNumber, channel);
  };

  /**
   * Memverifikasi kode verifikasi.
   * 
   * @param {string} phoneNumber - Nomor telepon yang diverifikasi.
   * @param {string} code - Kode verifikasi yang diterima pengguna.
   */
  const verifyCode = async (phoneNumber: string, code: string) => {
    await store.verifyCode(phoneNumber, code);
  };

  return {
    status: store.status,
    message: store.message,
    sendVerification,
    verifyCode,
  };
}
