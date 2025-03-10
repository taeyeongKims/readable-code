package cleancode.mission.day7.model.passlistprovider;

import cleancode.mission.day7.model.studycafepass.StudyCafePassType;

import java.util.Arrays;

public enum StudyCafePassListProvider implements StudyCafePassListProvidable {
    HOURLY(StudyCafePassType.HOURLY) {
        @Override
        public PassListProvider provide() {
            return new HourlyPassListProvider();
        }
    },
    WEEKLY(StudyCafePassType.WEEKLY) {
        @Override
        public PassListProvider provide() {
            return new WeeklyPassListProvider();
        }
    },
    FIXED(StudyCafePassType.FIXED) {
        @Override
        public PassListProvider provide() {
            return new FixedPassListProvider();
        }
    };

    private final StudyCafePassType studyCafePassType;

    StudyCafePassListProvider(StudyCafePassType studyCafePassType) {
        this.studyCafePassType = studyCafePassType;
    }

    public static <T extends PassListProvider> T findStudyCafeManger(StudyCafePassType passType) {
        StudyCafePassListProvider studyCafeMangerProvider = findBy(passType);

        return (T) studyCafeMangerProvider.provide();
    }

    private static StudyCafePassListProvider findBy(StudyCafePassType passType) {
        return Arrays.stream(values())
            .filter(provider -> provider.supports(passType))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("확인할 수 없는 매니저입니다."));
    }

    @Override
    public boolean supports(StudyCafePassType passType) {
        return passType == studyCafePassType;
    }
}
